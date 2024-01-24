const rows = document.querySelectorAll(".table-row")

rows.forEach((row) => {
    row.addEventListener("click", () => {
        const data = row.querySelector(".id").textContent + '\n' + row.querySelector(".miasto").textContent + '\n'
        + row.querySelector(".ulica").textContent + '\n' + row.querySelector(".budynek").textContent + '\n' +
        row.querySelector(".poczta").textContent
        //alert(data)
        document.getElementById("id-input").value = row.querySelector(".id").textContent
        document.getElementById("deleteId").value = row.querySelector(".id").textContent
        document.getElementById("miasto-input").value = row.querySelector(".miasto").textContent
        document.getElementById("ulica-input").value = row.querySelector(".ulica").textContent
        document.getElementById("budynek-input").value = row.querySelector(".budynek").textContent
        document.getElementById("poczta-input").value = row.querySelector(".poczta").textContent


        document.getElementById("form").style.display = "block";
        document.getElementById("overlay").style.display="block";
        window.setTimeout(function() {
          document.getElementById("overlay").style.opacity="0.5";
          document.getElementById("form").style.opacity="1";
          document.getElementById("form").style.top="0";
        }, 100);

    })
})

function close(){
    document.getElementById("overlay").style.opacity="0";
    document.getElementById("form").style.opacity="0";
    document.getElementById("form").style.top="30vh";
    window.setTimeout(function() {
         document.getElementById("form").style.display = "none";
         document.getElementById("overlay").style.display="none";
    }, 300);
}

document.onkeydown = (event) => {
    if(event.key === "Escape" && document.getElementById("form").style.display == "block"){
        close()
    }
}


document.getElementById("closeButton").addEventListener("click", () => {
    event.preventDefault();
    close();
})


document.getElementById("deleteButton").addEventListener("click", () => {
    event.preventDefault();
    document.getElementById("deleteForm").submit();
})