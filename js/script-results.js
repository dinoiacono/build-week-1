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

