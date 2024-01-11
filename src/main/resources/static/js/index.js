document.addEventListener("DOMContentLoaded", function() {
  const container = document.getElementById("train-container");
  let id = 0;
  let pastId=0;

  function createTrain() {
    const train = document.createElement("div");
    train.className = "train";


    const img = document.createElement("img");
    img.src = "../img/Uk_tram_icon.png";
    img.alt = "Train";
    train.appendChild(img);

    container.appendChild(train);

    const speed = Math.random() * 5 + 2;
    train.style.animationDuration = `${Math.random() * 2 + 2}s`;

    train.animate([
      { transform: "translateX(80vw)" },
      { transform: "translateX(50px)" }
    ], {
      duration: speed * 700,
      easing: "linear",
      iterations: 1
    });
    train.id = "train" + id;
    setTimeout(function() {
    removeTrains(train.id)
    }, speed*700)
    id++;
  }

  function removeTrains(trainId){
    trains = document.getElementById(trainId);
    trains.remove();
  }

  function generateTrains() {
    setInterval(createTrain, 700);
  }

  generateTrains();
});