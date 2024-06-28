const host = "http://localhost:8080";

const call_singup = (username, password) => {
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

  return fetch(`${host}/auth/signup`, requestOptions)
    .then((response) => {
      if (response.status === 200) {
        return response.json();
      } else {
        return null;
      }
    })
    .catch((error) => {
      console.log("error", error);
      return null;
    });
};
