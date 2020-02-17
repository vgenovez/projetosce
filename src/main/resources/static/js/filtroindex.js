//Total de linhas na tabela
var linhas = document.querySelectorAll(".asset");
recebelinhastotal(linhas.length);

//Total de linhas com asset "Nao"
var assetlinha = document.querySelectorAll(".asset");
var atsim = 0;    
var atnao = 0;
for (var i = 0; i < assetlinha.length; i++){
    
    var assetlinhas = assetlinha[i];
    var atposdoasset = assetlinhas.querySelector(".info-Posdoasset");
    var atposdoassets = atposdoasset.textContent;

    if (atposdoassets == "SIM"){   
        atsim += 1;
    }else{
        atnao += 1;
    }
    recebelinhassim(atsim);
    recebelinhasnao(atnao);
}

//Busca no Filtro
var campoBusca = document.querySelector("#filtrar-tabela");
campoBusca.addEventListener("input", function () {
    var asset = document.querySelectorAll(".asset");

    if (this.value.length > 0) {
        for (var i = 0; i < asset.length; i++) {
        	
        	var assets = asset[i];
            var recebevalor;
            var mostraFiltro = filtroSelect(recebevalor);

            var expressao = new RegExp(this.value, "i")

            if (mostraFiltro == "1") {
                var tdassettag = assets.querySelector(".info-Assettag")
                var assettag = tdassettag.textContent;

                if (!expressao.test(assettag)) {
                    assets.classList.add("invisivel");

                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "2") {
                var tdhostname = assets.querySelector(".info-Hostname")
                var hostname = tdhostname.textContent;

                if (!expressao.test(hostname)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "3") {
                var tdmodelo = assets.querySelector(".info-Modelo")
                var modelo = tdmodelo.textContent;

                if (!expressao.test(modelo)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "4") {
                var tdserie = assets.querySelector(".info-Serie")
                var serie = tdserie.textContent;

                if (!expressao.test(serie)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "5") {
                var tdtipo = assets.querySelector(".info-Tipo")
                var tipo = tdtipo.textContent;

                if (!expressao.test(tipo)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "6") {
                var tdfabricante = assets.querySelector(".info-Fabricante")
                var fabricante = tdfabricante.textContent;

                if (!expressao.test(fabricante)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "7") {
                var tdproprietario = assets.querySelector(".info-Proprietario")
                var proprietario = tdproprietario.textContent;

                if (!expressao.test(proprietario)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "8") {
                var tdlocalidade = assets.querySelector(".info-Localidade")
                var localidade = tdlocalidade.textContent;

                if (!expressao.test(localidade)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "9") {
                var tdusuario = assets.querySelector(".info-Usuario")
                var usuario = tdusuario.textContent;

                if (!expressao.test(usuario)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "10") {
                var tdlogin = assets.querySelector(".info-Login")
                var login = tdlogin.textContent;

                if (!expressao.test(login)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "11") {
                var tdnfiscal = assets.querySelector(".info-Nfiscal")
                var nfiscal = tdnfiscal.textContent;

                if (!expressao.test(nfiscal)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "12") {
                var tdstatusdoativo = assets.querySelector(".info-Statusdoativo")
                var statusdoativo = tdstatusdoativo.textContent;

                if (!expressao.test(statusdoativo)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "13") {
                var tdtecresponsavel = assets.querySelector(".info-TecResponsavel")
                var tecresponsavel = tdtecresponsavel.textContent;

                if (!expressao.test(tecresponsavel)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "14") {
                var tddatadecadastro = assets.querySelector(".info-Datadecadastro")
                var datadecadastro = tddatadecadastro.textContent;

                if (!expressao.test(datadecadastro)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "15") {
                var tdposdoasset = assets.querySelector(".info-Posdoasset")
                var posdoasset = tdposdoasset.textContent;

                if (!expressao.test(posdoasset)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "16") {
                var tdtecassetmanager = assets.querySelector(".info-TecassetManager")
                var tecassetmanager = tdtecassetmanager.textContent;

                if (!expressao.test(tecassetmanager)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }

            if (mostraFiltro == "17") {
                var tdcham = assets.querySelector(".info-Cham")
                var cham = tdcham.textContent;

                if (!expressao.test(cham)) {
                    assets.classList.add("invisivel");
                } else {
                    assets.classList.remove("invisivel");
                }
            }
        }
    } else {
        for (var i = 0; i < asset.length; i++) {
            var assets = asset[i];
            assets.classList.remove("invisivel")
        }
    }
});
// Função que busca o valor do filtro ao selecionar.
function filtroSelect(recebevalor) {
    var localId = document.getElementById("filtro");
    var recebevalor = localId.options[localId.selectedIndex].value;
    return recebevalor;
}

// Função que aplica o valor das linhas no HTML
function recebelinhastotal(recebelinhastotal) {
    document.getElementById("contalinhasTotal").innerHTML = "<label class='lblcontadorIndex' for='linha'>" + recebelinhastotal + "</label>";
}

function recebelinhassim(recebelinhassim) {
    document.getElementById("contalinhasatSIM").innerHTML = "<label class='lblcontadorIndex' for='linha'>" + recebelinhassim + "</label>";
}

function recebelinhasnao(recebelinhasnao) {
    document.getElementById("contalinhasatNAO").innerHTML = "<label class='lblcontadorIndex' for='linha'>" + recebelinhasnao + "</label>";
}



