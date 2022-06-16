/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const edit = document.querySelector("#edit");

edit.onclick = () => {
    editProduct()
};


function editProduct() {
    let id = document.getElementById("id");
    var name = document.getElementById("name");
    let image = document.getElementById("image");
    let price = document.getElementById("price");
    let title = document.getElementById("title");
    let description = document.getElementById("description");

    let options = {
        method: 'PUT',
        header: {
            'Content-Type': 'aplication/json'
        },
        body: JSON.stringify({
            id: id.value,
            name: name.value,
            image: image.value,
            price: price.value,
            title: title.value,
            description: description.value
        })
    }


    fetch('api-product', options)
            .then(res => {
                console.log(res.json())
                return res.json()
            })
            .then(data => {
                console.log(data);
            })

}
