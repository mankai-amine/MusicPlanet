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

function searchDisc(event) {
  event.preventDefault();
  const token = getCookie("token");

  document.getElementById("appendHere").innerHTML = "";

  let artistName = document.getElementById("discInput").value;

  var myHeaders = new Headers();
  myHeaders.append("Authorization", `Bearer ${token}`);

  var requestOptions = {
    method: "GET",
    headers: myHeaders,
    redirect: "follow",
  };

  fetch(`${host}/api/discography/${artistName}`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      result.forEach((album) => {
        // Create a new div element for each album
        const albumDiv = document.createElement("div");
        albumDiv.innerHTML = `Name: ${album.albumName}, Year: ${album.yearOfRelease}`;
        // Append the album div to the albumListDiv
        document.getElementById("appendHere").appendChild(albumDiv);
      });
    })
    .catch((error) => console.log("error", error));
}

function searchBio(event) {
  event.preventDefault();
  const token = getCookie("token");

  document.getElementById("appendHere").innerHTML = "";

  let artistName = document.getElementById("bioInput").value;

  var myHeaders = new Headers();
  myHeaders.append("Authorization", `Bearer ${token}`);

  var requestOptions = {
    method: "GET",
    headers: myHeaders,
    redirect: "follow",
  };

  fetch(`${host}/api/biography/${artistName}`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      let biography = result.biography;

      const bioDiv = document.createElement("div");
      bioDiv.innerHTML = `Biography: ${biography}`;

      document.getElementById("appendHere").appendChild(bioDiv);
    })
    .catch((error) => console.log("error", error));
}
