const questions = [
    {
      category: "Science: Computers",
      type: "multiple",
      difficulty: "easy",
      question: "What does CPU stand for?",
      correct_answer: "Central Processing Unit",
      incorrect_answers: [
        "Central Process Unit",
        "Computer Personal Unit",
        "Central Processor Unit",
      ],
    },
    {
      category: "Science: Computers",
      type: "multiple",
      difficulty: "easy",
      question:
        "In the programming language Java, which of these keywords would you put on a variable to make sure it doesn&#039;t get modified?",
      correct_answer: "Final",
      incorrect_answers: ["Static", "Private", "Public"],
    },
    {
      category: "Science: Computers",
      type: "boolean",
      difficulty: "easy",
      question: "The logo for Snapchat is a Bell.",
      correct_answer: "False",
      incorrect_answers: ["True"],
    },
    {
      category: "Science: Computers",
      type: "boolean",
      difficulty: "easy",
      question:
        "Pointers were not used in the original C programming language; they were added later on in C++.",
      correct_answer: "False",
      incorrect_answers: ["True"],
    },
    {
      category: "Science: Computers",
      type: "multiple",
      difficulty: "easy",
      question:
        "What is the most preferred image format used for logos in the Wikimedia database?",
      correct_answer: ".svg",
      incorrect_answers: [".png", ".jpeg", ".gif"],
    },
    {
      category: "Science: Computers",
      type: "multiple",
      difficulty: "easy",
      question: "In web design, what does CSS stand for?",
      correct_answer: "Cascading Style Sheet",
      incorrect_answers: [
        "Counter Strike: Source",
        "Corrective Style Sheet",
        "Computer Style Sheet",
      ],
    },
    {
      category: "Science: Computers",
      type: "multiple",
      difficulty: "easy",
      question:
        "What is the code name for the mobile operating system Android 7.0?",
      correct_answer: "Nougat",
      incorrect_answers: [
        "Ice Cream Sandwich",
        "Jelly Bean",
        "Marshmallow",
      ],
    },
    {
      category: "Science: Computers",
      type: "multiple",
      difficulty: "easy",
      question: "On Twitter, what is the character limit for a Tweet?",
      correct_answer: "140",
      incorrect_answers: ["120", "160", "100"],
    },
    {
      category: "Science: Computers",
      type: "boolean",
      difficulty: "easy",
      question: "Linux was first created as an alternative to Windows XP.",
      correct_answer: "False",
      incorrect_answers: ["True"],
    },
    {
      category: "Science: Computers",
      type: "multiple",
      difficulty: "easy",
      question:
        "Which programming language shares its name with an island in Indonesia?",
      correct_answer: "Java",
      incorrect_answers: ["Python", "C", "Jakarta"],
    },
  ];

  var indexRandom;
  const lunghezzaArray = questions.length;
  var contatore = 1;
  const domandeFatte = [];
  var risposte = [];
  var rand = Math.floor(Math.random()* risposte.length);
  var corrette = 0;
  var errate = 0;
  var Timer;
  var TimerValue = 60;
  var countdown;
  var timeLeft = TimerValue;
  var timePassed = 0;
  const FULL_DASH_ARRAY = 283;

  window.onload = function (){
    SeedRandom();
    countdownSecondi();
    TimerCheck(Timer);
  }


function SeedRandom(){
  let num = Math.floor(Math.random()* questions.length);
  indexRandom = num;
  RandomDomande();
}

function RandomDomande(){
  let _question = document.getElementById('h1-quetion').textContent = questions[indexRandom].question;
  NascondiBottoni();
  ContentitoreRisposte();
};

function NascondiBottoni (){
  if(questions[indexRandom].type=='boolean'){
    let botton1 = document.getElementById('button-3').style.display='none';
    let botton2 = document.getElementById('button-4').style.display='none';
  }
  else{
    let botton1 = document.getElementById('button-3').style.display= 'inline-block';
    let botton2 = document.getElementById('button-4').style.display= 'inline-block';
  }
}

function ContentitoreRisposte(){
  risposte = [];
  risposte.push(questions[indexRandom].correct_answer)
  for (let i = 0; i < questions[indexRandom].incorrect_answers.length; i++) {
    risposte.push(questions[indexRandom].incorrect_answers[i])
  }
  console.log(risposte);

  RandomContentArrayRisposte(risposte);

  let testoRisposta = document.querySelector("#button-1 p")
  testoRisposta.textContent = risposte[0];

  let testoRisposta1 = document.querySelector("#button-2 p")
  testoRisposta1.textContent = risposte[1];

  let testoRisposta2 = document.querySelector("#button-3 p")
  testoRisposta2.textContent = risposte[2];

  let testoRisposta3 = document.querySelector("#button-4 p")
  testoRisposta3.textContent = risposte[3];
}

function RandomContentArrayRisposte(inputArray){
  inputArray.sort(()=> Math.random() - 0.5);
}

console.log(risposte);

var bottone = document.querySelector('#button-1');
bottone.addEventListener('click', function(){
    let text = bottone.outerText;
    CheckRispostaCorretta(text)
})

var bottone1 = document.querySelector('#button-2');
bottone1.addEventListener('click', function(){
    let text = bottone1.outerText;
    CheckRispostaCorretta(text)
})

var bottone2 = document.querySelector('#button-3');
bottone2.addEventListener('click', function(){
    let text = bottone2.outerText;
    CheckRispostaCorretta(text)
})

var bottone3 = document.querySelector('#button-4');
bottone3.addEventListener('click', function(){
    let text = bottone3.outerText;
    CheckRispostaCorretta(text)
})

function CheckRispostaCorretta(value){
  let parola = value;
  if(parola === questions[indexRandom].correct_answer)
  {
    corrette++
    questions.splice(indexRandom, 1);
    if(questions.length == 0){
      nextPage();
    }
    else{
      SeedRandom();
    }
  }
  else{
    errate++
    questions.splice(indexRandom, 1);
    if(questions.length == 0){
      nextPage();
    }
    else{
      SeedRandom();
    }
  }
  clearInterval(countdown);
  countdownSecondi();
  Timer = TimerValue;
  timeLeft = TimerValue;
  timePassed = 0;
  contatore += 1;
  UpdateQuestionValue();
}

function UpdateQuestionValue(){
  let value = document.querySelector('.ValueQuestion');
  if(contatore <= lunghezzaArray)
    value.textContent = contatore + "/" + lunghezzaArray;
}

UpdateQuestionValue();

function nextPage(){
  window.location.href = 'result.html';
}

function calculateTimeFraction() {
  return timeLeft / TimerValue;
}

function setCircleDasharray() {
  const circleDasharray = `${(
    calculateTimeFraction() * FULL_DASH_ARRAY
  ).toFixed(0)} 283`;
  document
    .getElementById("base-timer-path-remaining")
    .setAttribute("stroke-dasharray", circleDasharray);
}



function countdownSecondi(){

  Timer = TimerValue;

   countdown = setInterval(function() { //avvio una funzione countdown
    timePassed = timePassed += 1;
    timeLeft = TimerValue - timePassed;
    Timer--; //decrementa il tempo restante di 1
    setCircleDasharray();
    TimerCheck(Timer);
  document.getElementById("contatore").innerHTML = Timer //aggiorna il valore nella sezione HTML

  },1000); //si esegue ogni 1000 millisecondi
}

function TimerCheck(timer){
  if(timer < 0)
  {
    timer = 0;
    clearInterval(countdown);
    if(questions.length == 0)nextPage();
    errate ++;
    contatore++;
    questions.splice(indexRandom, 1);
    SeedRandom();
    UpdateQuestionValue();
    countdownSecondi();
    Timer = TimerValue;
    timeLeft = TimerValue;
    timePassed = 0;
  }
}

//window.onload = countdownSecondi(); //in questo modo dico di avviare il countdown appena la pagina si è caricata
