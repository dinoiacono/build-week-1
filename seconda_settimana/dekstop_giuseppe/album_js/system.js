class ButtonController {
    clickButton = false;
}

//costanti
const NAVBAR = document.querySelector(".container-next-album-profile");
const NAVBAR_BUTTON_PLAY = document.querySelector(".container-button-play-nav");
const CONTAINER_TITLE_SONG = document.querySelector(".list-song");
const TITLE_ALBUM = document.querySelector("#title-album");
const TITLE_ARTIST = document.querySelector("#name-band");
const IMAGE_COVER_ALBUM = document.querySelector("#image-albun");
const IMAGE_SMALL_PROFILE_ARTIST = document.querySelector(".image-artist");
const TOTAL_SONGS = parseInt(document.querySelector("#total-song").innerHTML);
const TOTAL_DURATION = document.querySelector("#total-Timer");

//variabili
var EnableScrolling = false;
var TargetButton;
var LastTargetButton;
var clickButton;
// ---DEBUG ----- //

console.log(NAVBAR_BUTTON_PLAY);
console.log(CONTAINER_TITLE_SONG);
console.log(TITLE_ALBUM);
console.log(TITLE_ARTIST);
console.log(IMAGE_COVER_ALBUM);
console.log(IMAGE_SMALL_PROFILE_ARTIST);
console.log(TOTAL_SONGS);
console.log(TOTAL_DURATION);
console.log(TargetButton);

////---------FUNZIONI-----------////

function ReturnToUp(){
    document.body.scrollIntoView();
}

function CreateBoxSong(ValueIndex, TitleSong, ArtistName, TotalProduction, durationSong){
    var StorageValueIndex;
    //container
    var container = document.createElement("div");
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
    NameArtist.href = "www.google.it";
    //---- section Duration song + reproductions
    var containerCell = document.createElement("div");
    containerCell.className = "col-md-auto text-end me-5";
    //container Productions
    var containerProduction = document.createElement("div");
    containerProduction.className = "text-header-list";
    containerProduction.id = "text-reproduction";
    // text value Production
    var TextProduction = document.createElement("h6");
    TextProduction.className = "mb-0 container-text-info-song";
    TextProduction.id = "riprodaction-value";
    TextProduction.innerHTML = TotalProduction;
    //container Cell Duration
    var ContainerCellDuration = document.createElement("div");
    ContainerCellDuration.className = "col col-lg-2 text-end";
    //contaier Duration
    var containerDuration = document.createElement("h6");
    containerDuration.id = "duration-song";
    //text value Duration
    var ValueDuration = document.createElement("h6");
    ValueDuration.className = "mb-0";
    ValueDuration.id = "duration-value";
    ValueDuration.innerHTML = durationSong;
    // PARENT ELEMENT
    CONTAINER_TITLE_SONG.append(container);
    container.append(TextPostion);
    container.append(containerCell);
    container.append(ContainerCellDuration);
    ////////
    TextPostion.append(ContainerText);
    ContainerText.append(Index);
    ContainerText.append(containerInformation);
    containerInformation.append(Title);
    containerInformation.append(NameArtist);
    ////
    containerCell.append(containerProduction);
    containerProduction.append(TextProduction);
    /////
    ContainerCellDuration.append(containerDuration);    
    containerDuration.append(ValueDuration);
    // BUTTON FUNCTION


    container.addEventListener("mouseover", ()=>{
        Index.innerHTML = `\n<i class="bi bi-caret-right-fill"></i>\n`;
    })
    container.addEventListener("mouseleave", ()=>{
        if(!container.getAttribute('style'))Index.innerHTML = ValueIndex;   
    })

    container.addEventListener("click", ()=>{
        if(container.getAttribute('style'))
        {
            container.removeAttribute('style');
        }
        else{
            Index.innerHTML = `\n<i class="bi bi-caret-right-fill"></i>\n`;
            container.setAttribute('style', 'background-color: rgb(94, 94, 94);')
            TargetButton = container;
        }
        CheckTargetButton();
    })

}

function CheckTargetButton(){
    if(LastTargetButton != TargetButton)
    { 
        if(LastTargetButton != undefined)
        {
            LastTargetButton.removeAttribute('style'); 
            var value = LastTargetButton.querySelector("span").getAttribute("data-value");
            LastTargetButton.querySelector("#value-number-song").innerHTML = value;
            console.log(value);
        }
        LastTargetButton = TargetButton;
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

function CreationSong(){
    for (let i = 1; i < TOTAL_SONGS+1; i++) {
        CreateBoxSong(i, "Martello Grosso", "I spacca Maroni", "643,123","4:20");
    }
}



/* FUNZIONI DICHIRATE*/
CreationSong();



/* ------ METODI WINDOWS -------- */
window.onload = ReturnToUp();
window.onscroll = Scrolling;

