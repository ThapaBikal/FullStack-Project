import React, { Component } from "react";

class SignupForm extends Component {
  state = {};
  render() {
    return (
      <div>
        <form className="signup-form">
          <div>
            <label>First Name</label>
            <input type="first-name" className="form-control" />
          </div>
          <div>
            <label>Middle Name</label>
            <input type="middle-name" className="form-control" />
          </div>

          <div>
            <label>Last Name</label>
            <input type="first-name" className="form-control" />
          </div>
          <div className="mb-3">
            <label for="user-email" className="form-label">
              Email address
            </label>
            <input type="email" className="form-control" />
            <div id="emailHelp" class="form-text">
              We'll never share your email with anyone else.
            </div>
          </div>
          <div className="mb-3">
            <label for="user-password" className="form-label">
              Password
            </label>
            <input type="password" className="form-control" />
          </div>
          <div className="mb-3 form-check"></div>
          <button type="submit" className="btn btn-primary">
            Signup
          </button>
        </form>
      </div>
    );
  }
}

export default SignupForm;
