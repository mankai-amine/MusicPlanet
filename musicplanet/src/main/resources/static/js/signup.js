const signup = (event) => {
  event.preventDefault();

  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  call_singup(username, password).then((result) => {
    if (result === null) {
      document.getElementById("error_msg").innerHTML =
        "Username already exists";
    } else {
      call_login(username, password).then((result) => {
        const token = result.token;
        // save token to cookie
        const currentDate = new Date();
        // expires in 30 days
        const expiresData =
          new Date(currentDate).getTime() + 30 * 24 * 60 * 60 * 1000;
        const expires = expiresData.toLocaleString();
        document.cookie = `token=${token}; expires=${expires}; path=/`;
        window.location.replace("/me.html");
      });
    }
  });
};
