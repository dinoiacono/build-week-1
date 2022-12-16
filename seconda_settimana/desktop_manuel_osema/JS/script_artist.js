
let sorgenteDati = fetch ('https:striveschool-api.herokuapp.com/api/deezer/album/379976067')
.then((response) => response.json())
.then((datavalue) => {
    console.log(datavalue); 


    //impaginamento section con immagine, titolo e numero di ascolti 
    let nameArtista = document.getElementById("nome_artista");
    nameArtista.innerHTML = datavalue.artist.name;
    let ascolti = document.getElementById("totale_ascolti");
    ascolti.innerHTML = datavalue.artist.id.toLocaleString('en-US');
    let immagine = document.getElementById("section_1");
    immagine.setAttribute('style', `background-image: url(${datavalue.artist.picture_xl});`);


    for (let i = 0; i < popular; i++) {
    createTable(i+1,datavalue.tracks.data[i].title,datavalue.tracks.data[i].rank,datavalue.tracks.data[i].duration)
        
    }
});
//creazione lista brani

const container = document.querySelector("tbody");
var popular = 5;
 function createTable (numero, nomeCanzone ,product, duration){
    var strutturaTr = document.createElement("tr");
    var td1 = document.createElement("td"); 
    td1.id = "num-song";
    td1.innerHTML = numero;
    var td2 = document.createElement("td"); 
    td2.id = "image-song";
    td2.innerHTML = nomeCanzone;
    var td3 = document.createElement("td"); 
    td3.id = "tot-product";
    td3.innerHTML = product.toLocaleString('en-US');
    var td4 = document.createElement("td"); 
    td4.id = "duration-song";
    td4.innerHTML = fmtMSS(duration);
    
    container.append(strutturaTr);
    strutturaTr.append(td1);
    strutturaTr.append(td2);
    strutturaTr.append(td3);
    strutturaTr.append(td4);
    
    
}
createTable();
function fmtMSS(s){return(s-(s%=60))/60+(9<s?':':':0')+s}

