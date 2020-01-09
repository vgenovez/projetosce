var campoBusca = document.querySelector("#filtrar-tabela");
var linhas = document.getElementsByTagName('tr');

var count1 = 0;
var linha = linhas.length;
console.log(linha);

//Funçao de busca do Filtro
campoBusca.addEventListener("input", function () {
    var asset = document.querySelectorAll(".asset");

    if (this.value.length > 0) {
        for (var i = 0; i < asset.length; i++) {

            var assets = asset[i];
            console.log(parseInt(assets.length));
            var count = count1 + i;

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

// Função que aplica o valor das linhas no HTML label
function recebelinhas(recebelinhas) {
    document.getElementById("contalinhasTotal").innerHTML = "<label for='linha'>" + recebelinhas + "</label>";
}
