
let imgSingoloEvidenza = document.querySelector('.img_singolo_in_evidenza');
let titoloSingoloEvidenza = document.querySelector('.titolo_singolo_in_evidenza');
let titoloAlbumEvidenza = document.querySelector('.titolo_album_in_evidenza');
let autoreSingoloEvidenza = document.querySelector('.autore_singolo_in_evidenza');
let spanAutoreSingoloEvidenza = document.querySelector('.span_autore_singolo_in_evidenza');

let arrayImmagini = [];
let arrayTitoloTracce = [];
let arrayNomiAutori = [];



let sorgenteDati = fetch('https://striveschool-api.herokuapp.com/api/deezer/album/186080352')
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
        
    }

    let titoloAlbum = data.title;

    console.log(titoloAlbum);
    console.log(arrayTitoloTracce);
    console.log(arrayNomiAutori);






    // Generatore random
    const getRandomInt = ( min = 0, max = 1 ) => {

        return Math.floor( Math.random() * ( max - min + 1 ) ) + min;
        
    }

    let tracciaRandom = getRandomInt(0, (arrayTitoloTracce.length - 1)); //qui inseriamo l'array che vogliamo ciclare in modo random
    console.log(arrayTitoloTracce[tracciaRandom]);



    // Se voglio inserire manualmente i dati in html
    imgSingoloEvidenza.src = data.artist.picture_medium;
    titoloAlbumEvidenza.innerHTML = titoloAlbum;
    titoloSingoloEvidenza.innerHTML = arrayTitoloTracce[tracciaRandom];
    autoreSingoloEvidenza.innerHTML = arrayNomiAutori[0];
    spanAutoreSingoloEvidenza.innerHTML = arrayNomiAutori[0];

});