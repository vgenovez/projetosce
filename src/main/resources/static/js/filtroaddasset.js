// Mostra o form conforme o valor do status do ativo
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

// Função botão copiar ativo
$(function(){
    $('#btativo').click(function(){
        $('#textareaAtivo').select();
        var copiar = document.execCommand('copy');
        if(copiar){
            alert('Copiado');
        }else {
            alert('Erro ao copiar, mude o navegador');
        }
        return false;
    });
});

// Função botão copiar descarte
$(function(){
    $('#btdescarte').click(function(){
        $('#textareaDescarte').select();
        var copiar = document.execCommand('copy');
        if(copiar){
            alert('Copiado');
        }else {
            alert('Erro ao copiar, mude o navegador');
        }
        return false;
    });
});

// Função botão copiar estoque
$(function(){
    $('#btestoque').click(function(){
        $('#textareaEstoque').select();
        var copiar = document.execCommand('copy');
        if(copiar){
            alert('Copiado');
        }else {
            alert('Erro ao copiar, mude o navegador');
        }
        return false;
    });
});