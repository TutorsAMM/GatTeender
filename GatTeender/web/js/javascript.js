/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* //Vecchia funzione Javascript
 
function searchYourGato(){
   //Stringa da ricercare
    var wantedCat = $("#searchField")[0].value;

    // Lista di elementi prelevati dal DOM (nel nostro caso solo div)
    // con classe user (contenenti quindi gli utenti)
    // 
    var listOfCat = $(".user").toArray();

    //Ad ogni elemento con classe user, aggiungi la proprietà css "display"
    listOfCat.forEach(function(item, index){$(item).css("display", "");});

    //Per ogni elemento di classe listOfCat...
    for(var cat in listOfCat){
        //...cerca il tag h2 contenente il nome.
        var nomeGattoCorrente = $(listOfCat[cat]).find('h2').text();

        //Se la stringa cercata non corrisponde a nessun nome...
        if(nomeGattoCorrente.indexOf(wantedCat) === -1)
            //...nascondi quel div
            $(listOfCat[cat]).hide();
    }
}
*/

//crea un elemento div con classe user che rappresenta un utente (contenuto in gtt)
function createElement(gtt){
    var img = $("<img>")
            .attr("alt","Foto Profilo")
            .attr("src",gtt.urlFotoProfilo);
    var name = $("<h2>").html(gtt.nome);
    var link = $("<a>")
            .attr("href", "index.html?user="+gtt.id)
            .html("Link al Profilo");
    
    var userData = $("<div>")
            .attr("class","userData")
            .append(name)
            .append(link);
    var profilePic = $("<div>")
            .attr("class","profilePic")
            .append(img);
    
    
    return $("<div>")
            .attr("class","user")
            .append(profilePic)
            .append(userData);
}

function stateSuccess(data){
    var userListPage = $("#usersList");
    
    $(userListPage).empty();
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchYourGato").click(function(){
        
        var wantedCat = $("#searchField")[0].value;
        
        $.ajax({
            url: "CercaAmiciAjax",
            data:{
                cmd:"search",
                nomeGattoCercato: wantedCat
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});
