//costanti
const NAVBAR = document.querySelector(".container-next-album-profile");
const NAVBAR_BUTTON_PLAY = document.querySelector(".container-button-play-nav");
const CONTAINER_TITLE_SONG = document.querySelector(".list-song");
const TITLE_ALBUM = document.querySelectorAll("#title-album");
const TITLE_ARTIST = document.querySelector("#name-band");
const IMAGE_COVER_ALBUM = document.querySelector("#image-albun");
const IMAGE_SMALL_PROFILE_ARTIST = document.querySelector(".image-artist");
const LOGO_SMALL_PROFILE_ARTIST = document.querySelector("#img-profile-artist");
const TOTAL_SONGS = document.querySelector("#total-song");
const TOTAL_DURATION = document.querySelector("#total-Timer");
const DATA_PUBLISHING = document.querySelector("#data-publishig");
const URL_PARAMS = new URLSearchParams(window.location.search);
const VALUE_ID = parseInt(URL_PARAMS.get("ok"));
const FOOTER_TITLE_SONG = document.querySelector("#name-song");
const FOOTER_ARTIST_NAME = document.querySelector("#name-artist");
const FOOTER_IMAGE_BAND = document.querySelector("#image-band-footer");

console.log(FOOTER_TITLE_SONG);
console.log(VALUE_ID);
console.log(TOTAL_SONGS);
console.log(TITLE_ALBUM);


//variabili
var EnableScrolling = false;
var TargetButton;
var LastTargetButton;
var TargetPlayButton;
var LastTargetPlayButton;
var clickButton;
var totalsong;
var AudioPlay = new Audio();
var Buttons = [];

let seek_slider = document.querySelector(".seek_slider");
let volume_slider = document.querySelector(".volume_slider");
let curr_time = document.querySelector(".current-time");
let total_duration = document.querySelector(".total-duration");
let curr_track;

//metodo fetch
let sorgenteDati = fetch(`https://striveschool-api.herokuapp.com/api/deezer/album/${VALUE_ID}`)
.then((response) => response.json())
.then((datavalue) => {
    console.log(datavalue);
    TOTAL_SONGS.innerHTML = datavalue.nb_tracks + ' Brani';
    totalsong = datavalue.nb_tracks;

    for (let i = 0; i < totalsong; i++) {
        CreateBoxSong(i+1, datavalue.tracks.data[i].title, datavalue.artist.name, datavalue.tracks.data[i].rank, datavalue.tracks.data[i].duration, datavalue.tracks.data[i].preview);
    }
    CreateHeader(datavalue);
    FOOTER_IMAGE_BAND.src = datavalue.cover_medium;
    FOOTER_TITLE_SONG.innerHTML = datavalue.tracks.data[0].title;
    FOOTER_ARTIST_NAME.innerHTML = datavalue.artist.name;
    console.log(Buttons);
})

// ---DEBUG ----- //



console.log(NAVBAR_BUTTON_PLAY);
console.log(CONTAINER_TITLE_SONG);
console.log(TITLE_ALBUM);
console.log(TITLE_ARTIST);
console.log(IMAGE_COVER_ALBUM);
console.log(IMAGE_SMALL_PROFILE_ARTIST);
console.log(TOTAL_SONGS);
console.log(TOTAL_DURATION);

////---------FUNZIONI-----------////

function ReturnToUp(){
    document.body.scrollIntoView();
}

function buttonClick(){
    console.log("click");
}

function CreateHeader(data){

    for (let i = 0; i < TITLE_ALBUM.length; i++) {
        TITLE_ALBUM[i].innerHTML = data.title;
    }
    TITLE_ARTIST.innerHTML = data.artist.name;
    IMAGE_COVER_ALBUM.src = data.cover_medium;
    LOGO_SMALL_PROFILE_ARTIST.src = data.artist.picture;
    DATA_PUBLISHING.innerHTML = data.release_date;
    TOTAL_DURATION.innerHTML = data.duration + " min";
}

function CreateBoxSong(ValueIndex, TitleSong, ArtistName, TotalProduction, durationSong, audiosource){
    //container
    var container = document.createElement("div");
    Buttons.push(container);
    container.className = "row d-flex align-items-center m-0 box-contaier-song"; 
    // text position
    var TextPostion = document.createElement("div");
    TextPostion.className = "col text-start ps-0";
    // container Text List
    var ContainerText = document.createElement("div");
    ContainerText.className = "text-header-list";
    //Value index
    var Index = document.createElement("span");
    Index.id = "value-number-song";
    Index.innerHTML = ValueIndex;
    Index.setAttribute("data-value", ValueIndex);
    //audio soruce
    var audio = document.createElement("audio");
    audio.className = `audio-play`;
    audio.setAttribute("pd", "false");
    var _source = document.createElement("source");
    _source.src = audiosource;
    _source.setAttribute("type", "audio/mp3")
    console.log(audio);
    console.log(_source);
    //fine audio

    Index.addEventListener("click", ()=>{

        if(Index.className == "bi bi-pause-fill")
        {
            Index.className = `bi bi-caret-right-fill`;
            setTimeout(() => { audio.setAttribute("pd", "false"); }, 10);
            Title.removeAttribute("style");
            audio.pause();
        }
        else{
            setTimeout(() => { audio.setAttribute("pd", "true") }, 10);
            Index.className = `bi bi-pause-fill`;
            Title.setAttribute("style", "color: rgb(29, 185, 85)");
            audio.play();
            curr_track = audio;
            total_duration.innerHTML = fmtMSS(durationSong);
            seekTo();
            seekUpdate();
            updateTimer = setInterval(seekUpdate, 1000);
            FOOTER_TITLE_SONG.innerHTML = TitleSong;
            FOOTER_ARTIST_NAME.innerHTML = ArtistName;
        }
        TargetButton = container;
        TargetPlayButton = Index;
        CeckMiniPlayButton();
    })
    //Container for Song title + artis Name
    var containerInformation = document.createElement("div");
    containerInformation.className = "d-flex flex-column m-0";
    //Song Title
    var Title = document.createElement("h6");
    Title.className = "mb-0";
    Title.id = "title-song";
    Title.innerHTML = TitleSong;
    //Artist Name
    var NameArtist = document.createElement("a");
    NameArtist.className = "mb-0";
    NameArtist.innerHTML = ArtistName;
    NameArtist.id = "name-artist";
    NameArtist.href = `artist.html?ok=${VALUE_ID}`;
    //---- section Duration song + reproductions
    var containerCell = document.createElement("div");
    containerCell.className = "col-md-auto text-end me-5 d-none d-lg-block";
    //container Productions
    var containerProduction = document.createElement("div");
    containerProduction.className = "text-header-list";
    containerProduction.id = "text-reproduction";
    // text value Production
    var TextProduction = document.createElement("h6");
    TextProduction.className = "mb-0 container-text-info-song";
    TextProduction.id = "riprodaction-value";
    TextProduction.innerHTML = TotalProduction.toLocaleString('en-US');
    //container Cell Duration
    var ContainerCellDuration = document.createElement("div");
    ContainerCellDuration.className = "col col-lg-2 text-end";
    //contaier Duration
    var containerDuration = document.createElement("div");
    containerDuration.className = "d-inline-flex align-items-center m-0 text-end";
    containerDuration.id = "duration-song";
    //text value Duration
    var ValueDuration = document.createElement("h6");
    ValueDuration.className = "mb-0";
    ValueDuration.id = "duration-value";
    ValueDuration.innerHTML = fmtMSS(durationSong);
    // conteiner menu 
    var menu = document.createElement("div");
    menu.className = "button-menu-song hide";
    // list
    var elementList = document.createElement("li");
    elementList.className = "nav-item dropdown";
    //link button style
    var buttonstyle = document.createElement("a"); 
    buttonstyle.className = "nav-link";
    buttonstyle.href = "#";
    buttonstyle.setAttribute("role", "button")
    buttonstyle.setAttribute("data-bs-toggle", "dropdown")
    buttonstyle.setAttribute("aria-expanded", "false")
    //add icon
    var icon = document.createElement("i");
    icon.className = "bi bi-three-dots";
    // ul element
    var _ul = document.createElement("ul");
    _ul.className = "dropdown-menu dropdown-menu-end color-menu-down";
    // element li 1
    var li_1 = document.createElement("li");
    li_1.className = "m-1 d-flex";
    // element link 1
    var link_1 = document.createElement("a");
    link_1.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_1.href = "#";
    link_1.innerHTML = "Aggiundi in Coda";
    //divisor
    var divisor1 = document.createElement("li");
    divisor1.className = "m-1";
    //hr
    var line = document.createElement("hr");
    line.className = "dropdown-divider";
    // element li 2
    var li_2 = document.createElement("li");
    li_2.className = "m-1 d-flex";
    // element link 2
    var link_2 = document.createElement("a");
    link_2.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_2.href = "#";
    link_2.innerHTML = "Vai a Radio dal Brano";
    // element li 3
    var li_3 = document.createElement("li");
    li_3.className = "m-1 d-flex";
    // element link 3
    var link_3 = document.createElement("a");
    link_3.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_3.href = "#";
    link_3.innerHTML = "Vai all'album";
    // element li 4
    var li_4 = document.createElement("li");
    li_4.className = "m-1 d-flex";
    // element link 4
    var link_4 = document.createElement("a");
    link_4.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_4.href = "#";
    link_4.innerHTML = "Vai all'artista";
    // element li 5
    var li_5 = document.createElement("li");
    li_5.className = "m-1 d-flex";
    // element link 5
    var link_5 = document.createElement("a");
    link_5.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_5.href = "#";
    link_5.innerHTML = "Mostra riconoscimenti";
    // element li 6
    var li_6 = document.createElement("li");
    li_6.className = "m-1 d-flex";
    // element link 6
    var link_6 = document.createElement("a");
    link_6.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_6.href = "#";
    link_6.innerHTML = "Salva nei brani che ti piacciono";
    // element li 7
    var li_7 = document.createElement("li");
    li_7.className = "m-1 d-flex";
    // element link 7
    var link_7 = document.createElement("a");
    link_7.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_7.href = "#";
    link_7.innerHTML = "Aggiungi alla playlist";
    var divisor3 = document.createElement("li");
    divisor3.className = "m-1";
    //hr
    var line3 = document.createElement("hr");
    line3.className = "dropdown-divider";
    // element li 8
    var li_8 = document.createElement("li");
    li_8.className = "m-1 d-flex";
    // element link 8
    var link_8 = document.createElement("a");
    link_8.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_8.href = "#";
    link_8.innerHTML = "Condividi";
    // element li 9
    var li_9 = document.createElement("li");
    li_9.className = "m-1 d-flex";
    // element link 9
    var link_9 = document.createElement("a");
    link_9.className = "dropdown-item pb-2 pt-2 m-0 pe-0 ps-3";
    link_9.href = "#";
    link_9.innerHTML = "Apri con l'all per desktop";

    // PARENT ELEMENT
    CONTAINER_TITLE_SONG.append(container);
    container.append(TextPostion);
    container.append(containerCell);
    container.append(ContainerCellDuration);
    ////////
    TextPostion.append(ContainerText);
    ContainerText.append(Index);
    container.append(audio);
    audio.append(_source);
    ContainerText.append(containerInformation);
    containerInformation.append(Title);
    containerInformation.append(NameArtist);
    ////
    containerCell.append(containerProduction);
    containerProduction.append(TextProduction);
    /////
    ContainerCellDuration.append(containerDuration);    
    containerDuration.append(ValueDuration);
    containerDuration.append(menu);
    menu.append(elementList);
    elementList.append(buttonstyle);
    buttonstyle.append(icon);
    elementList.append(_ul);
    _ul.append(li_1);
    _ul.append(divisor1);
    divisor1.append(line);
    _ul.append(li_2);
    _ul.append(li_3);
    _ul.append(li_4);
    _ul.append(li_5);
    _ul.append(li_6);
    _ul.append(li_7);
    _ul.append(li_8);
    _ul.append(li_9);
    li_1.append(link_1);
    li_2.append(link_2);
    li_3.append(link_3);
    li_4.append(link_4);
    li_5.append(link_5);
    li_6.append(link_6);
    li_7.append(link_7);
    li_8.append(link_8);
    li_9.append(link_9);

    // BUTTON FUNCTION


    container.addEventListener("mouseover", ()=>{
        if(Index.className != "bi bi-pause-fill")
        {
            Index.className = `bi bi-caret-right-fill`;
            Index.innerText = "";
            menu.className = "button-menu-song visible";
        }
    })
    container.addEventListener("mouseleave", ()=>{
        if(Index.className != "bi bi-pause-fill"){
            if(!container.getAttribute('style')){
                Index.className = ``;
                Index.innerHTML = ValueIndex;}
            menu.className = "button-menu-song hide";
        }
    })

    container.addEventListener("click", ()=>{

        if(container.getAttribute('style'))
        {
            container.removeAttribute('style');
        }
        else{
            Index.innerText = "";
            container.setAttribute('style', 'background-color: rgb(94, 94, 94);')
        }
        TargetButton = container;
        CheckTargetButton();
    })

    container.addEventListener("dblclick", ()=>{
        if(audio.getAttribute("pd") == "false")
        {
            audio.play();
            setTimeout(() => { audio.setAttribute("pd", "true") }, 10);
            Index.className ="bi bi-pause-fill";
            FOOTER_TITLE_SONG.innerHTML = TitleSong;
            FOOTER_ARTIST_NAME.innerHTML = NameArtist;
        }
        else if(audio.getAttribute("pd") == "true"){
            audio.pause();   
            setTimeout(() => { audio.setAttribute("pd", "false") }, 10);
        }
    })
}

function isPlaying(audelem) { return !audelem.pause; }

function CeckMiniPlayButton(){
    if(LastTargetPlayButton != TargetPlayButton)
    {
        if(LastTargetPlayButton != undefined)
        {
            if(LastTargetPlayButton.className == "bi bi-pause-fill"){
                resetValues();
                var value = LastTargetPlayButton.getAttribute("data-value");
                LastTargetPlayButton.innerText = value;
                LastTargetPlayButton.className = "";
                LastTargetButton.removeAttribute('style');

            }
        }
        LastTargetPlayButton = TargetPlayButton;
        console.log(LastTargetPlayButton);
    }
}

function CheckTargetButton(){
    if(LastTargetButton != TargetButton)
    { 
        if(LastTargetButton != undefined)
        {
            LastTargetButton.removeAttribute('style');

            var audio = LastTargetButton.querySelector(`.audio-play`);
            audio.pause();
            //console.log(audio);
            //console.log(LastTargetButton);

            if(LastTargetButton.querySelector(".bi bi-pause-fill") != null) 
            {
                if(LastTargetButton.querySelector("#title-song").getAttribute("style") != null)
                LastTargetButton.querySelector("#title-song").removeAttribute("style");
            }

            if(LastTargetButton.querySelector("#value-number-song").className != "bi bi-pause-fill"){
                var value = LastTargetButton.querySelector("span").getAttribute("data-value");
                LastTargetButton.querySelector("#value-number-song").innerText = value;
                LastTargetButton.querySelector("#value-number-song").className = "";
                LastTargetButton.querySelector("#title-song").removeAttribute("style");
            }
        }
        setTimeout(() => { LastTargetButton = TargetButton; console.log("cambio") }, 100);
        
    }

}

function CreationAlbumPage(data){
    for (let i = 0; i < TITLE_ALBUM; i++) {
        TITLE_ALBUM.innerHTML = data
    }
}

const Scrolling = ()=>{
    if(this.scrollY > 300 && !EnableScrolling)
    {
        //azione
        NAVBAR_BUTTON_PLAY.classList.remove('d-none');
        NAVBAR.setAttribute("style", "background-color: rgb(107, 92, 39); ");
        EnableScrolling = true;
        console.log(NAVBAR_BUTTON_PLAY);
    }
    else if(this.scrollY < 300 && EnableScrolling)
    {
        //azione
        NAVBAR_BUTTON_PLAY.classList.add('d-none');
        NAVBAR.removeAttribute("style");
        EnableScrolling = false;
        console.log("ritorno");
    }
} 

function convertHMS(value) {
    const sec = parseInt(value, 10);
    let hours   = Math.floor(sec / 3600); // get hours
    let minutes = Math.floor((sec - (hours * 3600)) / 60);
    let seconds = sec - (hours * 3600) - (minutes * 60);
    return minutes+':'+ seconds;
}

function AddColorGreen(title){
    title.classList.add("color-green-text");
    console.log(title);
}

function RemoveColorGreen(title){
    title.classList.remove("color-green-text");
    console.log(title);
}

function fmtMSS(s){return(s-(s%=60))/60+(9<s?':':':0')+s}
/* FUNZIONI DICHIRATE*/


/* ------ METODI WINDOWS -------- */
window.onload = ReturnToUp();
window.onscroll = Scrolling;
 
/*BARRA*/

    function seekTo() {
      seekto = curr_track.duration * (seek_slider.value / 100);
      curr_track.currentTime = seekto;
    }

    function setVolume() {
      curr_track.volume = volume_slider.value / 100;
    }

    function seekUpdate() {
      let seekPosition = 0;

      // Check if the current track duration is a legible number
      if (!isNaN(curr_track.duration)) {
        seekPosition = curr_track.currentTime * (100 / curr_track.duration);
        seek_slider.value = seekPosition;

        // Calculate the time left and the total duration
        let currentMinutes = Math.floor(curr_track.currentTime / 60);
        let currentSeconds = Math.floor(curr_track.currentTime - currentMinutes * 60);
        let durationMinutes = Math.floor(curr_track.duration / 60);
        let durationSeconds = Math.floor(curr_track.duration - durationMinutes * 60);

        // Adding a zero to the single digit time values
        if (currentSeconds < 10) { currentSeconds = "0" + currentSeconds; }
        if (durationSeconds < 10) { durationSeconds = "0" + durationSeconds; }
        if (currentMinutes < 10) { currentMinutes = "0" + currentMinutes; }
        if (durationMinutes < 10) { durationMinutes = "0" + durationMinutes; }

        curr_time.textContent = currentMinutes + ":" + currentSeconds;
        total_duration.textContent = durationMinutes + ":" + durationSeconds;
      }
    }

    function resetValues() {
        curr_time.textContent = "00:00";
        seek_slider.value = 0;
    }
