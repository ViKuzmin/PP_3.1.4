
let response = fetch("http://localhost:8080/api/users").then(
    res => {res.json().then(
        data => {console.log(data);
            if(data.length > 0) {
                console.log("DATA LENGTH "+data[1].size);
                let temp = "";
                data.forEach((u) => {
                    temp += "<tr>";
                    temp += "<td>" + u.id + "<td>";
                    temp += "<td>" + u.firstName + "<td>";
                    temp += "<td>" + u.lastName + "<td>";
                    temp += "<td>" + u.age + "<td>";
                    temp += "<td>" + u.username + "<td><tr>";
                })
                document.getElementById("data").innerHTML = temp;
            }
        }
    )}
)

let url = "http://localhost:8080/api/users"

function sendRequestGet(method, url) {
    return fetch(url).then(response => {
            response.json()
        })
}

function sendRequestPost(method, url, body = null) {
    const headers = {}
    return fetch(url,
    {
        method: method,
        body: JSON.stringify(body),
        headers: headers
    }
    ).then(response => {
        response.json()
    })
}
