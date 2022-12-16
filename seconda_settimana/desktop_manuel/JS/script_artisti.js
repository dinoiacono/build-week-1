//selettori header
const nomeArtista = document.querySelector('#nome-artista');
const numeroAscolti = document.querySelector('#numero-ascoltatori');
const imgArtista = document.querySelector('#section_1')

//selettore contenitori brani
const contenitoreBrani = document.querySelector('.contenitore-brani')


 async function prendiDatiArtista(){
    let artista = await fetch('https://striveschool-api.herokuapp.com/api/deezer/artist/412');
    let datiArtista = await artista.json()
    //console.log(dati);
    compilaArtista(datiArtista);
    let canzoniPopolari = await fetch (datiArtista.tracklist);
    let listaCanzoni = await canzoniPopolari.json()
    console.log(listaCanzoni);
    listaCanzoni.data.forEach(element => {
        creaBrano(element)
    });

}
//console.log(imgArtista);

prendiDatiArtista();

function compilaArtista(dati){
    nomeArtista.textContent = dati.name;
    numeroAscolti.textContent = dati.nb_fan + ' fan';
    imgArtista.style.backgroundImage = `url(${dati.picture_xl})`;
};


function creaBrano(element){
   let contenitore = document.createElement('div');
   contenitore.className = 'row align-items-center mb-3 contenitore-brano';
   
    let copertina = document.createElement('img');
   copertina.className = 'col-3 px-0';
   copertina.src = element.album.cover_small;
   
   let titolo = document.createElement('p');
   titolo.innerText = `${element.title_short}`;
   titolo.className = 'col-8';

   let puntini = document.createElement('i');
   puntini.className = 'bi bi-three-dots col-1 fs-4 p-0';

   contenitoreBrani.append(contenitore);
   contenitore.appendChild(copertina);
   contenitore.appendChild(titolo);
   contenitore.appendChild(puntini);
}