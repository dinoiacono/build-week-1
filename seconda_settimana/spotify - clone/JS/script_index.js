
let imgSingoloEvidenza = document.querySelector('.img_singolo_in_evidenza');
let titoloSingoloEvidenza = document.querySelector('.titolo_singolo_in_evidenza');
let titoloAlbumEvidenza = document.querySelector('.titolo_album_in_evidenza');
let autoreSingoloEvidenza = document.querySelector('.autore_singolo_in_evidenza');
let spanAutoreSingoloEvidenza = document.querySelector('.span_autore_singolo_in_evidenza');
let containerBungiorno = document.querySelector(".preferiti");
let containerPiacere = document.querySelector(".altri_preferiti");

//let Preferiti = document.querySelectorAll(".preferito");
//console.log(Preferiti);



let arrayImmagini = [];
let arrayTitoloTracce = [];
let arrayNomiAutori = [];

let AlbumId = ['379976067','269122192','1434890','1442650','73123','6883271'];
let RandomSeed = Math.floor(Math.random() * AlbumId.length);
console.log(parseInt(AlbumId[RandomSeed]))

/* SALUTO AUTOMATICO*/
let contenitore = document.querySelector('#saluto');
        const ora = new Date().getHours();
        console.log(ora);

        function generaSaluto(orario){
     if (orario < 5) {
            contenitore.innerText = 'Buonanotte patatina';
        } else if(orario < 12) {
            contenitore.innerText = 'Buongiorno, ben risvegliato cuccioletta';
        }else if(orario < 19) {
            contenitore.innerText = 'Buon Pomeriggio cavalluccio marino';
        }else{
            contenitore.innerText = 'Buonasera stellina';
        }
    }
    window.addEventListener(onload, generaSaluto(ora));


let sorgenteDati = fetch(`https://striveschool-api.herokuapp.com/api/deezer/album/${AlbumId[RandomSeed]}`)


.then((response) => response.json())
.then((data) => {

    console.log(data);

    for (let i = 0; i < data.tracks.data.length; i++) {

        let primi_elementi = data.tracks.data[i];
        console.log(primi_elementi);
    
        let titoliTracce = primi_elementi.title_short;
        arrayTitoloTracce.push(titoliTracce);
        
        let autoriTracce = primi_elementi.artist.name;
        arrayNomiAutori.push(autoriTracce);
        
        /*

        Preferiti[0].querySelector("img").src = data.cover_small;
        Preferiti[1].querySelector("img").src = data.cover_small;
        Preferiti[2].querySelector("img").src = data.cover_small;
        Preferiti[3].querySelector("img").src = data.cover_small;
        Preferiti[4].querySelector("img").src = data.cover_small;
        Preferiti[5].querySelector("img").src = data.cover_small;

        Preferiti[0].querySelector(".testo-playlist").innerHTML = data.tracks.data[0].title_short;
        Preferiti[1].querySelector(".testo-playlist").innerHTML = data.tracks.data[1].title_short;
        Preferiti[2].querySelector(".testo-playlist").innerHTML = data.tracks.data[2].title_short;
        Preferiti[3].querySelector(".testo-playlist").innerHTML = data.tracks.data[3].title_short;
        Preferiti[4].querySelector(".testo-playlist").innerHTML = data.tracks.data[4].title_short;
        Preferiti[5].querySelector(".testo-playlist").innerHTML = data.tracks.data[5].title_short;
        */

    }


    function CreationBoxPlayListMedium(image, title, subtitle) {

        //creazione container
        var container = document.createElement("a")
        container.className = "altro_preferito";
        container.href = `album.html?ok=${AlbumId[RandomSeed]}`;
        //creazione cover
        var cover = document.createElement("img");
        cover.src = image;
        // testo
        var text = document.createElement("p");
        text.className = "titolo_playlist";
        text.innerHTML =title;
        // subtitle
        var _subtitle = document.createElement("a");
        _subtitle.className = "sub-titolo-playlist";
        _subtitle.innerHTML =subtitle;
        _subtitle.href = `artist.html?ok=${AlbumId[RandomSeed]}`;
        // icon
        var iconHeart = document.createElement("ion-icon");
        iconHeart.name = 'heart-outline';
        var puntini = document.createElement("p");
        puntini.innerHTML = '&middot;&middot;&middot;';
        var numeroBrani = document.createElement("p");
        numeroBrani.innerHTML = '16 brani';
        var iconPlay = document.createElement("ion-icon");
        iconPlay.name = 'play-circle';

        var containerIcone = document.createElement('div');
        containerIcone.className = "riga-sotto";

        var containerSopra = document.createElement('div');
        containerSopra.className = "riga-sopra";
        var containerTestiSopra = document.createElement('div');
        containerTestiSopra.className = "testi-sopra";
        var containerSx = document.createElement('div');
        containerSx.className = "riga-sinistra";
        var containerDx = document.createElement('div');
        containerDx.className = "riga-destra";

        containerSx.append(iconHeart);
        containerSx.append(puntini);
        containerDx.append(numeroBrani);
        containerDx.append(iconPlay);

        containerIcone.append(containerSx);
        containerIcone.append(containerDx);

        containerTestiSopra.append(text);
        containerTestiSopra.append(_subtitle);

        //append
        containerPiacere.append(container);

        containerSopra.append(cover);
        containerSopra.append(containerTestiSopra);

        container.append(containerSopra);
        container.append(containerIcone);

        container.addEventListener("click", ()=>{
            localStorage.setItem("id", AlbumId[RandomSeed])
        })
    }


    function CreationBoxPlayListSmall(cover, title){
        //creazione container
        var container = document.createElement("a");
        container.className ="preferito";
        container.href = `album.html?ok=${AlbumId[RandomSeed]}`;
        //creazione immagine;
        var image = document.createElement("img");
        image.src = cover;
        //creazione container Testo 
        var _title = document.createElement("div");
        _title.className ="testi";
        _title.innerHTML = title;
        //creazione container
        //  creazione testo
        var text = document.createElement("testo-playlist");
        text.className = "testo-playlist";
        //append
        containerBungiorno.append(container);
        container.append(image);
        container.append(_title);
        _title.append(text);

        container.addEventListener("click", ()=>{
            console.log("bottone");
        })
    }


    CreationBoxPlayListSmall(data.cover_medium, data.tracks.data[0].title_short);
    CreationBoxPlayListSmall(data.cover_medium, data.tracks.data[1].title_short);
    CreationBoxPlayListSmall(data.cover_medium, data.tracks.data[2].title_short);
    CreationBoxPlayListSmall(data.cover_medium, data.tracks.data[3].title_short);
    CreationBoxPlayListSmall(data.cover_medium, data.tracks.data[4].title_short);
    CreationBoxPlayListSmall(data.cover_medium, data.tracks.data[5].title_short);


    CreationBoxPlayListMedium(data.cover_medium, data.tracks.data[0].title_short, data.artist.name);
    CreationBoxPlayListMedium(data.cover_medium, data.tracks.data[1].title_short, data.artist.name);
    CreationBoxPlayListMedium(data.cover_medium, data.tracks.data[2].title_short, data.artist.name);
    CreationBoxPlayListMedium(data.cover_medium, data.tracks.data[3].title_short, data.artist.name);
    CreationBoxPlayListMedium(data.cover_medium, data.tracks.data[4].title_short, data.artist.name);
    //CreationBoxPlayListMedium(data.cover_medium, data.tracks.data[5].title_short, data.artist.name);

    let titoloAlbum = data.title;

    /*    console.log(titoloAlbum);
    console.log(arrayTitoloTracce);
    console.log(arrayNomiAutori);*/







    // Generatore random
    const getRandomInt = ( min = 0, max = 1 ) => {

        return Math.floor( Math.random() * ( max - min + 1 ) ) + min;
        
    }

    let tracciaRandom = getRandomInt(0, (arrayTitoloTracce.length - 1)); //qui inseriamo l'array che vogliamo ciclare in modo random
    //console.log(arrayTitoloTracce[tracciaRandom]);



    // Se voglio inserire manualmente i dati in html
    imgSingoloEvidenza.src = data.artist.picture_medium;
    titoloAlbumEvidenza.innerHTML = titoloAlbum;
    titoloSingoloEvidenza.innerHTML = arrayTitoloTracce[tracciaRandom];
    autoreSingoloEvidenza.innerHTML = arrayNomiAutori[0];
    spanAutoreSingoloEvidenza.innerHTML = arrayNomiAutori[0];

});