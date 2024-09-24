document.addEventListener("DOMContentLoaded", function () {
  //draw barlines
  const leftSide = document.querySelector(".left-side");
  let numberOfImages = 60;
  for (let i = 0; i < numberOfImages; i++) {
    // Create a div for each barline
    // const barlineDiv = document.createElement("div");
    // div.classList.add("div");
    // div.style.backgroundColor = "green";
    // leftSide.appendChild(div);

    const img = document.createElement("img");
    img.src = "barline.png";
    img.alt = "Barline Image";
    img.classList.add("bar-item");
    leftSide.appendChild(img);
  }

  //draw notes

  // function Note(step, octave, type, alter) {
  //   this.step = step;
  //   this.octave = octave;
  //   this.type = type;
  //   this.alter = alter;
  // }
  // const noteList = [];

  // for (let i = 0; i < 10; i++) {
  //   const newNote = new Note("C", 2, "Whole", "none");
  //   noteList.push(newNote);
  // }

  // for (let i = 0; i < noteList.length; i++) {
  //   const img = document.createElement("img");
  //   img.src = "whole.png";
  //   img.alt = "whole Image";
  //   img.classList.add("whole-item");

  //   img.style.top;
  //   const spacing = 50;
  //   img.style.left = `${25 + i * spacing}px`;
  //   leftSide.appendChild(img);
  //   console.log(i);
  // }

  // console.log(noteList.length);
});
