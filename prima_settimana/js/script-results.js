var numCorrette = localStorage.getItem('risposteCorrette');
var numErrate = localStorage.getItem('risposteErrate');
var lunghezzaArray = localStorage.getItem('numDomande');


var numeroRisultatoCorr = Number(numCorrette);
var numeroRisultatoErr = Number(numErrate);
var domande = Number(lunghezzaArray);

var percentualeCorrette = (numeroRisultatoCorr / domande) * 100;
//console.log(percentualeCorrette + '%');
var percentualeErrate = (numeroRisultatoErr / domande) * 100;
//console.log(percentualeErrate + '%');

document.querySelector('#corrette').innerHTML = percentualeCorrette + '%';
document.querySelector('#errate').innerHTML = percentualeErrate + '%';
document.querySelector('#contatore-corrette').innerHTML = numeroRisultatoCorr + '/' + domande + ' questions';
document.querySelector('#contatore-errate').innerHTML = numeroRisultatoErr + '/' + domande + ' questions';

let myCanvas = document.querySelector("#myCanvas").getContext("2d");
let myLabels = ["WRONG", "CORRECT"];
let myData = [numeroRisultatoErr, numeroRisultatoCorr];

let chart = new Chart(myCanvas, {
  type: "doughnut",
  data: {
    labels: myLabels,
    datasets: [
      {
        label: "Punteggio",
        data: myData,
        backgroundColor: ["#D20094", "#00FFFF"],
        borderWidth: "0.1",
        hoverBorderColor: "#000000",
        hoverBorderWidth: 0.1,
        hoverOffset: 0.1,
        cutout: "70%",
      },
    ],
  },
  options: {
    plugins: {
      legend: {
        display: false,
      },
    },
  },
});

var contenitoreEsito = document.querySelector('#congratulazioni');
var contenitoreTesto = document.querySelector('#testo-sotto');
if (percentualeCorrette > 60) {
  contenitoreEsito.innerHTML = 'Congratulations<br><span class="blue_text">You passed the exam.</span> ';
  contenitoreTesto.innerHTML = "We'll send you the certificate<br> in few minutes.<br>Check your email (including<br> promotions / spam folder)";
} else {
  contenitoreEsito.innerHTML = '<br><span class="blue_text">Oh no!</span>';
  contenitoreTesto.innerHTML = "Unfortunately <b>you didn't pass it.</b>";
}
