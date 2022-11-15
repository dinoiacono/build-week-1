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

  var indexRandom = Math.floor(Math.random()* questions.length);
  const lunghezzaArray = questions.length;
  var contatore = 1;
  const domandeFatte = [];
  const risposte = [];
  var rand = Math.floor(Math.random()* risposte.length);
  var lunghezzaRand = [];
  var corrette = 0;
  var errate = 0;
  console.log(indexRandom);

  window.onload = function () {
    RandomDomande();
    NascondiBottoni();
    ContentitoreRisposte();
  };


function RandomDomande(){
  let _question = document.getElementById('h1-quetion').textContent = questions[indexRandom].question;
};

function NascondiBottoni (){
  if(questions[indexRandom].type=='boolean'){
    let botton1 = document.getElementById('button-3').style.display='none';
    let botton2 = document.getElementById('button-4').style.display='none';
  }
}

function ContentitoreRisposte(){
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

var bottone = document.getElementsByClassName('button-style');
for(let elementi of bottone){
  addEventListener('click', function (){
    
      corrette++;
    
    })
  }

console.log(corrette);

console.log(bottone);


