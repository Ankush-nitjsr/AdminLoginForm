let formClick = document.querySelector(".loginForm");
formClick.addEventListener("submit", submitForm);

function submitForm(e) {
    e.preventDefault();
    const loginId = document.getElementById("login_id").value;
    const password = document.getElementById("password").value;

    axios.post('http://localhost:8080/https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp', {
        login_id: loginId,
        password: password
      })
      .then(function (response) {
        console.log(response);
        alert(response.data + "\n" + "Go to customer List page to view details of all the customers");
      })
      .catch(function (error) {
        console.log(error);
      });
}

function getAllCustomers() {
    fetch("http://localhost:8080/https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp/get_customer_list", {
        method: "GET",
        headers: {
          Authorization: "token"
        }
      })
        .then((response) => response.json())
        .then((data) => {

          const table = document.getElementById("table");
                  for(let i = 0; i < data.length; i++) {
                  var a = "hi";
                      let row = `<tr>
                                      <td>${data[i].first_name}</td>
                                      <td>${data[i].last_name}</td>
                                      <td>${data[i].address}</td>
                                      <td>${data[i].city}</td>
                                      <td>${data[i].state}</td>
                                      <td>${data[i].email}</td>
                                      <td>${data[i].phone}</td>
                                      <td>
                                      <button onclick="deleteCustomer(${data[i].userId})">⛔</button>
                                      <button onclick="updateCustomer(${data[i].userId})">🖊</button>
                                      </td>
                                 </tr>`;
                      table.innerHTML += row;
                  }
//          document.querySelector(".loginForm").style.display = "none";
//          document.querySelector(".customerList").style.display = "block";
        })
        .catch((error) => {
          console.log("Error:", error);
        });
}

function deleteCustomer(uuid) {

    alert(uuid);
    axios.delete(`http://localhost:8080/https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp/delete?uuid={uuid}`, {
        headers: {
                Authorization: "token",
        },
        data: {
                uuid: uuid,
        },
    })
    .then(function (response) {
            console.log(response);
    })
          .catch(function (error) {
            console.log(error);
    });
}

function updateCustomer() {
  const firstName = document.getElementById("firstName").value;
  const lastName = document.getElementById("lastName").value;
  const street = document.getElementById("street").value;
  const address = document.getElementById("address").value;
  const city = document.getElementById("city").value;
  const state = document.getElementById("state").value;
  const email = document.getElementById("email").value;
  const phone = document.getElementById("phone").value;

  axios.post('http://localhost:8080/https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp/update', {
          first_name: firstName,
          last_name: lastName,
          street: street,
          address: address,
          city: city,
          state: state,
          email: email,
          phone: phone
      })
      .then(function (response) {
          console.log(response);
      })
      .catch(function (error) {
          console.log(error);
      });
}



let addNewCustomerFormClick = document.querySelector(".AddNewCustomer");
addNewCustomerFormClick.addEventListener("submit", createNewCustomer);

console.log("create new customer form");

function createNewCustomer(e) {
    e.preventDefault();
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const street = document.getElementById("street").value;
    const address = document.getElementById("address").value;
    const city = document.getElementById("city").value;
    const state = document.getElementById("state").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;

    axios.post('http://localhost:8080/https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp/create', {
        first_name: firstName,
        last_name: lastName,
        street: street,
        address: address,
        city: city,
        state: state,
        email: email,
        phone: phone
    })
    .then(function (response) {
        console.log(response);
    })
    .catch(function (error) {
        console.log(error);
    });
}

