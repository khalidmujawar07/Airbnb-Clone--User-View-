var userid;

// ---------------------------SIgn Up---------------------------------------------------
function signUp() {
    const url = "http://localhost:8080/postbook/webapi/project/usersbnb/add";

    const data = {
        userName: document.getElementById("username").value,
        userEmail: document.getElementById("useremail").value,
        userPassword: document.getElementById("userpassword").value,
		userPassword: document.getElementById("useraddress").value,
		userPassword: document.getElementById("usermobile").value,
    };
    document.getElementById("username").value = "";
    document.getElementById("useremail").value = "";
    document.getElementById("userpassword").value = "";
	document.getElementById("useraddress").value = "";
	document.getElementById("usermobile").value = "";

    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    })
        .then((resp) =>{
            return resp.json()}
            ).then((data) =>{
            alert("signup success")
			console.log(data);
            userid=data.userId;
            console.log(userid);
        }) 
        .catch((err) => {
            console.log("Error" + err);
        });
       
}



// -----------------------Sign In---------------------------------------------------------

function signIn() {
    const userLogin = {
        userEmail: document.getElementById("useremaillogin").value,
        userPassword: document.getElementById("userpasswordlogin").value,
    }
	document.getElementById("useremaillogin").value = "";
    document.getElementById("userpasswordlogin").value = "";

    fetch("http://localhost:8080/postbook/webapi/project/usersbnb/login", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userLogin)
    })
    .then((res) => {
		
       return res.json()})
    .then((data) => {
        userid=data.userId;
        console.log(userid);
		console.log(data);
        alert("Login Successfull!")
        enableTabs();
		document.getElementById("feed-tab").disabled = false;
	document.getElementById("profile-tab").disabled = false;
	document.getElementById("my-properties-tab").disabled = false;
	document.getElementById("sign-in-tab").hidden = true;
	document.getElementById("sign-up-tab").hidden = true;
	document.getElementById("logout-tab").hidden = false;
    })
    .catch((err) => {
        console.log("Error" + err);
    });
}



// toggle signin signup 
document.getElementById("sign-in-tab").addEventListener("click", toggleSignInSignUp);
document.getElementById("sign-up-tab").addEventListener("click", toggleSignInSignUp);
document.getElementById("feed-tab").addEventListener("click", toggleHome);


function toggleSignInSignUp() {
	var signInForm = document.getElementById("sign-in-tab-pane");
	var signUpForm = document.getElementById("sign-up-tab-pane");

	signInForm.classList.toggle("d-none");
	signUpForm.classList.toggle("d-none");
}
function toggleHome(){
	var signInForm = document.getElementById("sign-in-tab-pane");
	signInForm.classList.toggle("d-none");
}

// -------------------------Enables Tab --------------------------------------------------------------

function enableTabs() {
    // Enable the Feed, Profile, and My Tweets tabs
    document.getElementById("feed-tab").removeAttribute("disabled");
    document.getElementById("profile-tab").removeAttribute("disabled");
    document.getElementById("my-properties-tab").removeAttribute("disabled");

    // Switch to the Profile tab after enabling
    const feedTab = new bootstrap.Tab(document.getElementById("feed-tab"));
    feedTab.show();
}

// ------------------------------Lgout---------------------------------------------------

function logout() {
	document.getElementById("feed-tab").disabled = true;
	document.getElementById("profile-tab").disabled = true;
	document.getElementById("my-properties-tab").disabled = true;
	document.getElementById("sign-in-tab").hidden = false;
	document.getElementById("sign-up-tab").hidden = false;
	document.getElementById("logout-tab").hidden = true;
  
	// const signInTabButton = document.getElementById("sign-in-tab");
	// signInTabButton.click();

	var signInTabButton = new bootstrap.Tab(document.getElementById('sign-in-tab'));
	signInTabButton.show();
  }


  
//--------------------- All Properties Function--------------------------------------------------------

function allProperties(){
	fetch("http://localhost:8080/postbook/webapi/project/properties/allproperties", {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.then(resp => resp.json())
		.then(data => {
			viewproperties(data)
			// return data;
			console.log(data);
		  })
	

}



// -----------Card of All Properties-----------------------------------------------------------

function viewproperties(properties){
	let listString = '<div class="container"><div class="row">';
for (let i = 0; i < properties.length; i++) {
    listString += `
	<div class="col-md-4 mb-4">
	<div class="card" style="width: 18rem;">
		<img src="${properties[i].propertyImage}" class="card-img-top" alt="Property Image 1">
		<div class="card-body">
			<h5 class="card-title">${properties[i].propertyTitle}</h5>
			<p class="card-text" id="location${i}">${properties[i].propertyLocation}, ${properties[i].propertyCity}</p>
			<p class="card-text">${properties[i].propertyType}</p>
			<p class="card-text">Price: ${properties[i].propertyPrice}</p>
			<p class="card-text">${properties[i].propertyDescription}</p>
			<a href="#" class="btn btn-primary">Go somewhere</a>
		</div>
	</div>
</div>`;
}
listString += '</div></div>';

document.getElementById('propertyList').innerHTML = listString;
}

//--------------------- My Properties Function--------------------------------------------------------

function myProperties(){
	fetch(`http://localhost:8080/postbook/webapi/project/properties/myProperties/${userid}`, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.then(resp => resp.json())
		.then(data => {
			viewmyproperties(data)
			console.log(data);
		  })

}

// -----------Card of My Properties-----------------------------------------------------------

function viewmyproperties(properties){
	let listString = '<div class="container"><div class="row">';
for (let i = 0; i < properties.length; i++) {
	listString += `
	<div class="col-md-4 mb-4">
	<div class="card" style="width: 18rem;">
		<img src="${properties[i].propertyImage}" class="card-img-top" alt="Property Image 1">
		<div class="card-body">
			<h5 class="card-title">${properties[i].propertyTitle}</h5>
			<p class="card-text" id="location${i}">${properties[i].propertyLocation}, ${properties[i].propertyCity}</p>
			<p class="card-text">${properties[i].propertyType}</p>
			<p class="card-text">Price: ${properties[i].propertyPrice}</p>
			<p class="card-text">${properties[i].propertyDescription}</p>
			<a href="#" id ="delete"  class="btn btn-primary">Delete</a>
		</div>
	</div>
</div>`;
}
listString += '</div></div>';

document.getElementById('myPropertyList').innerHTML = listString;
}




// --------------------------Filter Logic-------------------------------------------------------------------------


async function getAllProperties(){
	try {
		const res= await fetch("http://localhost:8080/postbook/webapi/project/properties/allproperties");

		const data = await res.json();
		return data;

		
	} catch (error) {
		console.log(error);
	}
	
		
	
}


async function search() {
	const searchTerm = document
	  .getElementById("find")
	  .value.toLowerCase();
  
	const items = await getAllProperties();
  
	const filteredItems = items.filter(
	  (item) =>
		item.propertyTitle.toLowerCase().includes(searchTerm) ||
		item.propertyLocation.toLowerCase().includes(searchTerm)
	);
  
	viewproperties(filteredItems);
  }
  











// -------------------------- Profile Page ---------------------------------------------------


  function viewProfile() {
	fetch(`http://localhost:8080/postbook/webapi/project/usersbnb/getUser/${userid}`)
	  .then((resp) => {
		if (resp.ok) {
		  return resp.json();
		} else {
		  throw new Error("Failed to fetch profile data");
		}
	  })
	  .then((data) => {
		console.log(data)
		const profileTabContent = `
        <div class="container mt-5">
          <div class="card">
            <div class="card-header">
              <h2 class="card-title">User Profile</h2>
            </div>
            <div class="card-body">
              <div class="row">
                <div class="col-md-3">
                  <div class="profile-avatar text-center">
                    <img src="${data.userAvatar}" alt="User Avatar" class="avatar-img img-fluid rounded-circle">
                  </div>
                </div>
                <div class="col-md-9">
                  <div class="profile-details">
                    <div class="mb-3 profile-input">
                      <label for="updatedUserName" class="form-label">UserName:</label>
                      <input type="text" id="updatedUserName" value="${data.userName}" class="form-control" disabled>
                    </div>
                    <div class="mb-3 profile-input">
                      <label for="updatedUserEmail" class="form-label">UserEmail:</label>
                      <input type="text" id="updatedUserEmail" value="${data.userEmail}" class="form-control" disabled>
                    </div>
                    <div class="mb-3 profile-input">
                      <label for="updatedUserAddress" class="form-label">UserAddress:</label>
                      <input type="text" id="updatedUserAddress" value="${data.userAddress}" class="form-control" disabled>
                    </div>
                    <div class="mb-3 profile-input">
                      <label for="updatedUserMobile" class="form-label">UserMobile:</label>
                      <input type="text" id="updatedUserMobile" value="${data.userMobile}" class="form-control" disabled>
                    </div>
					<div>
					<label for="updatedUserAvatar" class="form-label">User Avatar:</label>
					<div class="input-group">
					  <input type="text" id="updatedUserAvatar" value="${data.userAvatar}" class="form-control" disabled>
                  </div>
				  </div>
                </div>
              </div>
            </div>
            <div class="card-footer">
              <button id="updateProfileBtn" class="btn btn-primary">Update Profile</button>
              <button id="saveChangesBtn" class="btn btn-success" style="display:none;">Save Changes</button>
            </div>
          </div>
        </div>`;
		document.getElementById("getprofile").innerHTML = profileTabContent;
		document.getElementById("updateProfileBtn").addEventListener("click", function() {
  
		  document.getElementById("updatedUserName").disabled = false;
		  document.getElementById("updatedUserEmail").disabled = false;
		  document.getElementById("updatedUserAddress").disabled = false;
		  document.getElementById("updatedUserMobile").disabled = false;
		  document.getElementById("updatedUserAvatar").disabled = false;
		  document.getElementById("updateProfileBtn").style.display = 'none';
		  document.getElementById("saveChangesBtn").style.display = 'block';
		});  
  
		document.getElementById("saveChangesBtn").addEventListener("click", function() {
		  saveChanges(data.userId);
		});
	  })
	  .catch((error) => {
		console.error("Error fetching profile data:", error);
	  });
  }
  
  function saveChanges(userId) {
	const updatedUserData = {
	  userId: userid,
	  userName: document.getElementById("updatedUserName").value,
	  userEmail: document.getElementById("updatedUserEmail").value,
	  userAddress: document.getElementById("updatedUserAddress").value,
	  userMobile: document.getElementById("updatedUserMobile").value,
	  userAvatar: document.getElementById("updatedUserAvatar").value,
	};
  
	fetch(`http://localhost:8080/postbook/webapi/project/usersbnb/updateUser`, {
	  method: "PUT",
	  headers: {
		"Content-Type": "application/json",
	  },
	  body: JSON.stringify(updatedUserData),
	})
	  .then((resp) => {
		if (resp.ok) {
		  console.log("Profile updated successfully");
		  $('#updateProfileSuccessModal').modal('show');
		} else {
		  console.error("Failed to update profile:", resp.statusText);
		  $('#updateProfileFailModal').modal('show');
		}
	  })
	  .catch((error) => {
		console.error("Error updating profile:", error);
		$('#updateProfileFailModal').modal('show');
	  });
  }
  







































// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// -----------------------After Search hold the results ----------------------------------------------------------------- 
// function search() {
//     let filter = document.getElementById('find').value.toUpperCase();
//     let items = document.getElementsByClassName('card');
//     let searchResultsContainer = document.getElementById('searchResults');

//     // Clear previous search results
//     searchResultsContainer.innerHTML = '';

//     // Show only the cards that match the search criteria
//     for (let i = 0; i < items.length; i++) {
//         let location = document.getElementById(`location${i}`).textContent.toUpperCase();

//         if (location.indexOf(filter) > -1) {
//             searchResultsContainer.appendChild(items[i].cloneNode(true));
//         }
//     }
// }



// -----------------------Filter (GPT)-----------------------------------------------

// function search() {
//     let filter = document.getElementById('find').value.toUpperCase();

//     let items = document.getElementsByClassName('card');

//     for (let i = 0; i < items.length; i++) {
//         let location = document.getElementById(`location${i}`).textContent.toUpperCase();

//         if (location.indexOf(filter) > -1) {
//             items[i].style.display = "block";
//         } else {
//             items[i].style.display = "none";
//         }
//     }
// }


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


// My search func
// function search(){
// 	let filter = document.getElementById('find').value.toUpperCase();

// 	let item = document.getElementByClass('card');

// 	let l = document.getElementById('location');

// 	for(var i = 0;i<=l.length;i++){
// 		let a = item[i].getElementById('location')[0];

// 		let value = a.innerHTML || a.innerText  || a.textContent;
// 		if(value.toUpperCase().indexOf(filter) >-1){

// 		}
// 		else{
// 			item[i].style.display="none";
// 		}
// 	}

	
// }
// --------------------------------------------------------------------------------------

// -------------------------- Search Bar ------------------------------------------------------------------

// function searchProperties() {
//     // Retrieve the search input value
//     const searchInputValue = document.getElementById('find').value;

//     // Implement your logic to search properties based on the input value
//     // For example, you can filter the existing property list or make an API call to fetch matching properties.

//     // Update the property list accordingly
//     // Example: document.getElementById('propertyList').innerHTML = updatedPropertyListHTML;
// }