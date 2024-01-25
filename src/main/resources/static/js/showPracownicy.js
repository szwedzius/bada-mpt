const rows = document.querySelectorAll(".table-row")

rows.forEach((row) => {
    row.addEventListener("click", () => {
        //alert(data)
        document.getElementById("id-input").value = row.querySelector(".id").textContent
        document.getElementById("deleteId").value = row.querySelector(".id").textContent
        document.getElementById("imie-input").value = row.querySelector(".imie").textContent
        document.getElementById("nazwisko-input").value = row.querySelector(".nazwisko").textContent
        document.getElementById("urodzenia-input").value = row.querySelector(".data_urodzenia").textContent
        document.getElementById("pesel-input").value = row.querySelector(".pesel").textContent
        document.getElementById("konto-input").value = row.querySelector(".nr_konta").textContent
        document.getElementById("umowa-input").value = row.querySelector(".koniec_umowy").textContent
        document.getElementById("biuro-input").value = row.querySelector(".id_biura").textContent
        document.getElementById("zajezdnia-input").value = row.querySelector(".id_zajezdni").textContent
        document.getElementById("adres-input").value = row.querySelector(".id_adresu").textContent
        document.getElementById("stanowisko-input").value = row.querySelector(".id_stanowiska").textContent
        document.getElementById("plec-input").value = row.querySelector(".plec").textContent

        document.getElementById("form").style.display = "block";
        document.getElementById("overlay").style.display="block";
        window.setTimeout(function() {
          document.getElementById("overlay").style.opacity="0.5";
          document.getElementById("form").style.opacity="1";
          document.getElementById("form").style.top="0";
        }, 100);

    })
})

document.getElementById("plus").addEventListener("click", () => {
    document.getElementById("form2").style.display = "block";
    document.getElementById("overlay2").style.display="block";
    window.setTimeout(function() {
        document.getElementById("overlay2").style.opacity="0.5";
        document.getElementById("form2").style.opacity="1";
        document.getElementById("form2").style.top="0";
    }, 100);
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

function close2(){
    document.getElementById("overlay2").style.opacity="0";
    document.getElementById("form2").style.opacity="0";
    document.getElementById("form2").style.top="30vh";
    window.setTimeout(function() {
         document.getElementById("form2").style.display = "none";
         document.getElementById("overlay2").style.display="none";
    }, 300);
}


document.onkeydown = (event) => {
    if(event.key === "Escape" && document.getElementById("form").style.display == "block"){
        close()
    }
    if(event.key === "Escape" && document.getElementById("form2").style.display == "block"){
        close2()
    }
}


document.getElementById("closeButton").addEventListener("click", () => {
    event.preventDefault();
    close();
})

document.getElementById("closeButton5").addEventListener("click", () => {
    event.preventDefault();
    close2();
})


document.getElementById("deleteButton").addEventListener("click", () => {
    event.preventDefault();
    document.getElementById("deleteForm").submit();
})