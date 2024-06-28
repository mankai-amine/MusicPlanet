function getCookie(name) {
  let cookieArr = document.cookie.split(";");
  for (let i = 0; i < cookieArr.length; i++) {
    let cookiePair = cookieArr[i].split("=");
    if (name == cookiePair[0].trim()) {
      return decodeURIComponent(cookiePair[1]);
    }
  }
  return null;
}

window.onload = () => {
  const token = getCookie("token");

  var myHeaders = new Headers();
  myHeaders.append("Authorization", `Bearer ${token}`);

  var requestOptions = {
    method: "GET",
    headers: myHeaders,
    redirect: "follow",
  };

  fetch("http://localhost:8000/user/me", requestOptions)
    .then((response) => response.json())
    .then((result) => {
      const username = result.username;
      document.getElementById("username").innerHTML = username;
    })
    .catch((error) => console.log("error", error));
};
