function move() {
    var qtyMovedBury = getNumber(document.getElementById("qtyMovedBury").value);
    var qtyMovedPreston = getNumber(document.getElementById("qtyMovedPreston").value);
    var qtyMovedWarrinton = getNumber(document.getElementById("qtyMovedWarrinton").value);
    var qtyMovedArndale = getNumber(document.getElementById("qtyMovedArndale").value);
    var mybarcode = barcode_searched;
    let url = location.origin + "/stockmove/all" + "/" + qtyMovedBury  + "/" +qtyMovedPreston  + "/" +qtyMovedWarrinton + "/" +qtyMovedArndale + "/" + mybarcode;
    fetch(url).then((response) => {
        location.reload();
    });
}

function moveAll() {
    let url = location.origin + "/stockmove/move/";
    fetch(url, {
        method: 'POST'
    }).then(response => {
        console.log("Moved all cached stock");
        location.reload();
    })
}

function clearAll () {
    let url = location.origin + "/stockmove/clean/";
    fetch(url, {
        method: 'POST'
    }).then(response => {
        console.log("Clear all cached stock");
        location.reload();
    })
}

function getNumber(qty) {
    if(qty===""){
        return 0;
    }else {
        return parseInt(qty);
    }
}

function totalMoved() {
    var qtyMovedBury = document.getElementById("qtyMovedBury").value;
    var qtyMovedPreston = document.getElementById("qtyMovedPreston").value;
    var qtyMovedWarrinton = document.getElementById("qtyMovedWarrinton").value;
    var qtyMovedArndale = document.getElementById("qtyMovedArndale").value;
    var qtyMoved = parseInt(qtyMovedBury || 0) + parseInt(qtyMovedPreston|| 0) + parseInt(qtyMovedWarrinton|| 0) + parseInt(qtyMovedArndale|| 0);
    document.getElementById('totalMoved').value = -qtyMoved;
}


function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
}

$(document).ready(function () {
    $('#dataTable').DataTable({
        "aaSorting": [],
        columnDefs: [{
            orderable: false,
            targets: 0
        }]
    });
    $('.dataTables_length').addClass('bs-select');
});

