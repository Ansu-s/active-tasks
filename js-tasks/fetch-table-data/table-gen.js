async function getData(){
    try {
        const response = await fetch("https://jsonplaceholder.typicode.com/todos");
        if (!response.ok) {
            throw new Error("No data found");
        }
        const data = await response.json();
        createTable(data);
    } catch (error) {
        console.error("Error:", error.message);
    }
}
function createTable(data){
    const tableSpace = document.getElementById("table-space");
    const table = document.createElement("table");
    const headerRow = table.insertRow();
    for (const tableHeading in data[0]) {
        const heading = document.createElement("th");
        heading.textContent = tableHeading;
        heading.appendChild(headerRow);
    }
    data.forEach(record => {
        const row = table.insertRow();
        for (const field in record) {
            const cell = row.insertCell();
            cell.textContent = record[field];
        }
    });
    tableSpace.appendChild(table);
}
getData();