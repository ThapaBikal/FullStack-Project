import React, { Component } from "react";
import "./app.css";

class LoginForm extends Component {
  state = {};
  render() {
    return (
      <div>
        <form className="login-form">
          <div className="mb-3">
            <label for="user-email" className="form-label">
              Email address
            </label>
            <input type="email" className="form-control" />
          </div>
          <div className="mb-3">
            <label for="user-password" class="form-label">
              Password
            </label>
            <input type="password" className="form-control" />
          </div>
          <div className="mb-3 form-check">
            <input type="checkbox" className="form-check-input" />
            <label className="form-check-label" for="exampleCheck1">
              Stay loggged in
            </label>
          </div>
          <button type="submit" className="btn btn-primary">
            Login
          </button>
        </form>
      </div>
    );
  }
}

export default LoginForm;
