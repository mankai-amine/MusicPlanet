const signup = (event) => {
  event.preventDefault();

  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  var api_result = null;

  call_singup(username, password).then((result) => {
    api_result = result;
  });

  if (api_result === null) {
    document.getElementById("error_msg").innerHTML = "Username already exists";
  } else {
    console.log(api_result);
  }
};
