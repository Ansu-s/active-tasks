
async function loginUser() {
    try {
        const url = "http://localhost:8080/user/login";
        const requestBody = {
            email: "user@email.com",
            password: "123@abc"
        };

        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(requestBody)
        });

        if (!response.ok) {
            throw new Error("Login failed");
        }

        const token = await response.json();
        return token.value;
    } catch (error) {
        console.error(error.message);
        return null;
    }
}

async function fetchCatalogItems() {
    try {
        const generatedToken = await loginUser();
        if (!generatedToken) {
            console.log(" Token is not correct");
            return null;
        }

        const myheaders = {
            "X-AUTH-TOKEN": generatedToken
        };

        const response = await fetch("http://localhost:8080/catalogItems", {
            method: "GET",
            headers: myheaders,
            mode: "cors"
        });

        if (!response.ok) {
            if (response.status === 401) {
                throw new Error("Unauthorized Acess Requested");
            } else {
                throw new Error("Fetching Failed " + response.status);
            }
        }

        const responseData = await response.json();
        return responseData;
    } catch (error) {
        console.error("Error:", error.message);
        return null;
    }
}

async function displayTable(catalogData){
    const tableSpace = document.getElementById("table-space");
    const table = document.createElement("table");
    const headerRow = table.insertRow();
    for (const catalogDataKey in catalogData[0]) {
        const heading = document.createElement("th")
        heading.textContent = catalogDataKey;
        headerRow.appendChild(heading);
    }

    catalogData.forEach(record => {
        const tableRow = table.insertRow();
        for(const field in record){
            const cell = tableRow.insertCell();
            cell.textContent = record[field]
        }
    });
    tableSpace.appendChild(table);

}
async function fetchAndDisplayCatalogItems() {
    try {
        const catalogItems = await fetchCatalogItems();
        await displayTable(catalogItems);
        if (catalogItems) {
            console.log("Catalog Items:", catalogItems);
        } else {
            console.log("Failed to fetch catalog items.");
        }

    } catch (error) {
        console.error('Error:', error.message);
    }
}
fetchAndDisplayCatalogItems();
