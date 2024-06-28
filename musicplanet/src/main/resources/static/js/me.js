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

  fetch(`${host}/user/me`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      const username = result.username;
      document.getElementById("username").innerHTML = username;
    })
    .catch((error) => console.log("error", error));

  document.getElementById("search").addEventListener("click", search);
};

function search() {
  const token = getCookie("token");

  var myHeaders = new Headers();
  myHeaders.append("Authorization", `Bearer ${token}`);

  var requestOptions = {
    method: "GET",
    headers: myHeaders,
    redirect: "follow",
  };

  fetch(`${host}/api/discography/coldplay`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      console.log(result);
      const albumName = result[0].albumName;
      document.getElementById("mesg").textContent = albumName;
    })
    .catch((error) => console.log("error", error));
}
