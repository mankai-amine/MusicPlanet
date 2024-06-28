const login = (event) => {
  event.preventDefault();

  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;
  const error_element = document.getElementById("error_msg");

  const raw = JSON.stringify({
    username: username,
    password: password,
  });

  var requestOptions = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: raw,
    redirect: "manual",
  };

  fetch("http://localhost:8000/auth/login", requestOptions)
    .then((response) => {
      if (response.status === 200) {
        return response.json();
      } else {
        error_element.innerHTML = "Invalid username or password";
      }
    })
    .then((result) => {
      const token = result.token;
      // save token to cookie
      const currentDate = new Date();
      // expires in 30 days
      const expiresData =
        new Date(currentDate).getTime() + 30 * 24 * 60 * 60 * 1000;
      const expires = expiresData.toLocaleString();
      document.cookie = `token=${token}; expires=${expires}; path=/`;
      window.location.replace("/me.html");
    })
    .catch((error) => console.log("error", error));
};
