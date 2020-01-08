var campoStAtivo = document.getElementById("stdoativo");
var recebeStAtivo = campoStAtivo.value;

if (recebeStAtivo == "Ativo"){
    document.getElementById("formestoque").style.display = "none";
    document.getElementById("formdescarte").style.display = "none";
}else if (recebeStAtivo == "Estoque") {
    document.getElementById("formativo").style.display = "none";
    document.getElementById("formdescarte").style.display = "none";
}else if (recebeStAtivo == "Descarte"){
    document.getElementById("formativo").style.display = "none";
    document.getElementById("formestoque").style.display = "none";
}
    