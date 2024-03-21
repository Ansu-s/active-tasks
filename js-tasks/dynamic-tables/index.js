const table = document.getElementById("user").getElementsByTagName('tbody')[0];
let slNo = 1;

function addRow() {

    const newRow = table.insertRow();
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    const cell4 = newRow.insertCell(3);

    cell1.innerHTML = slNo;
    cell2.innerHTML = '<input type="text" name="name">';
    cell3.innerHTML = '<input type="text" name="email">';
    cell4.innerHTML = '<input type =text name adress>';

    slNo += 1;
}

function deleteLastRow(button) {
    const lastRowIndex = table.rows.length - 1;
    if (lastRowIndex >= 0) {
        table.deleteRow(lastRowIndex);
        slNo -= 1;
    }
}
