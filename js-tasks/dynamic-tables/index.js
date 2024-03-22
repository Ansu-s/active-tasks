const table = document.getElementById("user").getElementsByTagName('tbody')[0];
let slNo = 1;

function addRow() {

    const newRow = table.insertRow();
    const checkboxCell = newRow.insertCell(0)
    const cell1 = newRow.insertCell(1);
    const cell2 = newRow.insertCell(2);
    const cell3 = newRow.insertCell(3);
    const cell4 = newRow.insertCell(4);

    checkboxCell.innerHTML = '<input type = "checkbox" name = "deleteSelect">'
    cell1.innerHTML = slNo;
    cell2.innerHTML = '<input type="text" name="name">';
    cell3.innerHTML = '<input type="text" name="email">';
    cell4.innerHTML = '<input type =text name adress>';

    slNo += 1;
}
function selectAll(checkbox) {
    const checkboxes = document.getElementsByName('deleteSelect');
    checkboxes.forEach((cb) => {
        cb.checked = checkbox.checked;
    });
}
function deleteSelectedRows() {
    const checkboxes = document.getElementsByName('deleteSelect');
    for (let i = checkboxes.length - 1; i >= 0; i--) {
        if (checkboxes[i].checked) {
            table.deleteRow(i);
        }
    }
    updateSerialNo();
    slNo = table.rows.length + 1;
}
function updateSerialNo(){
    const rowsAfterDeletion = table.getElementsByTagName('tr')
    for(let j = 0 ; j<rowsAfterDeletion.length;j++){
        rowsAfterDeletion[j].cells[1].innerHTML= j+1;
    }
}

