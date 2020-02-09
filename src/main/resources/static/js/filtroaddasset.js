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

// Funçao para copiar

$('#btcopiar').click(function(){
$('#formativo').select();
try {
        var ok = document.execCommand('copy');
        if (ok) { alert('Texto copiado para a área de transferência'); }
    } catch (e) {
    alert(e)
}
});
    