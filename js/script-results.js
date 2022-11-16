var numCorrette = localStorage.getItem('risposteCorrette');
var numErrate = localStorage.getItem('risposteErrate');
var lunghezzaArray = localStorage.getItem('numDomande');


var numeroRisultatoCorr = Number(numCorrette);
var numeroRisultatoErr = Number(numErrate);
var domande = Number(lunghezzaArray);

var percentualeCorrette = (numeroRisultatoCorr/domande)*100;
//console.log(percentualeCorrette + '%');
var percentualeErrate = (numeroRisultatoErr/domande)*100;
//console.log(percentualeErrate + '%');

document.querySelector('#corrette').innerHTML = percentualeCorrette + '%';
document.querySelector('#errate').innerHTML = percentualeErrate + '%';
document.querySelector('#contatore-corrette').innerHTML = numeroRisultatoCorr + '/' + domande + ' questions';
document.querySelector('#contatore-errate').innerHTML = numeroRisultatoErr + '/' + domande + ' questions';

let myCanvas = document.querySelector("#myCanvas").getContext("2d");
  let myLabels = ["Sbagliate", "Giuste"];
  let myData =  [numeroRisultatoErr, numeroRisultatoCorr];

  let chart = new Chart(myCanvas, {
    type: "doughnut",
    data: {
      labels: myLabels,
      datasets: [
        {
          label: "Punteggio",
          data: myData,
          backgroundColor: ["#D20094", "#00FFFF"],
          hoverBorderColor: ,
          hoverBorderWidth: 1,
          hoverOffset: 2,
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
