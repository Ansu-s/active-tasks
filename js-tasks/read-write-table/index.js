const table = document.getElementById("cityTable").getElementsByTagName('tbody')[0];
let slNo = 1;

function addCity() {
    const insertedCity = document.getElementById("cityName");
    const cityName = insertedCity.value.trim();
    if (cityName !== '') {
        const newRow = table.insertRow();
        const checkboxCell = newRow.insertCell(0);
        const cell1 = newRow.insertCell(1);
        const cell2 = newRow.insertCell(2);

        checkboxCell.innerHTML = '<input type="checkbox" name="deleteSelect">';
        cell1.innerHTML = slNo++;
        cell2.innerHTML = cityName;

        insertedCity.value = '';
    } else {
        alert('Enter a city name to add it to the table');
    }
}

function deleteSelectedCities() {
    const checkboxes = document.getElementsByName('deleteSelect');
    for (let i = checkboxes.length - 1; i >= 0; i--) {
        if (checkboxes[i].checked) {
            table.deleteRow(i);
        }
    }
    updateSerialNo();
}

function updateSerialNo() {
    const rowsAfterDeletion = table.getElementsByTagName('tr');
    for (let j = 0; j < rowsAfterDeletion.length; j++) {
        rowsAfterDeletion[j].cells[1].innerHTML = j + 1;
    }
}

function selectAll(checkbox) {
    const checkboxes = document.getElementsByName('deleteSelect');
    checkboxes.forEach((cb) => {
        cb.checked = checkbox.checked;
    });
}
