class LoginResponseModel {
  final String token;
  final String error;

  LoginResponseModel({this.token, this.error});

  factory LoginResponseModel.fromJson(Map<String, dynamic> json) {
    return LoginResponseModel(
      token: json["key"] != null ? json["key"] : "",
      error: json["error"] != null ? json["error"] : "",
    );
  }
// Map<String, dynamic> toJson() {
//   final Map <String, dynamic> data= new Map <String, dynamic>();
//   data['token'] = this.token;
//   if (this.token != null) {
//   data['token']= this.token.toJson();
//   }
//   }
// }
}

class LoginRequestModel {
  String email;
  String password;

  LoginRequestModel({
    this.email,
    this.password,
  });

  Map<String, dynamic> toJson() {
    Map<String, dynamic> map = {
      'username': email.trim(),
      'password': password.trim(),
    };

    return map;
  }
}
