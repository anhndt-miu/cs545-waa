import React, { useRef } from 'react';
import ApiService from '../services/ApiServices';
import { useDispatch } from 'react-redux';
import { useNavigate, useLocation } from 'react-router-dom';
import { authActions } from '../app/Store';
import Cookies from 'js-cookie';

function Login() {
    const navigate = useNavigate();
    const location = useLocation();
    const from = location.state?.from?.pathname || "/";

    const dispatch = useDispatch();
    const emailRef = useRef('e2@abc.com');
    const passwordRef = useRef('123');
   

    const handleSubmit = async (event) => {
        try {
            event.preventDefault();
            const email = emailRef.current.value;
            const password = passwordRef.current.value;

            if (email.trim().length === 0 || password.trim().length === 0) {
                alert("Please fill in all fields");
            } else {
             const response =   await ApiService.doAuthen({
                    "email": email,
                    "password": password
                });

                if (response.accessToken) {
                    dispatch(authActions.loginSuccessful());
                    Cookies.set('user', response.accessToken);
                    navigate(from, { replace: true });
                }

                console.log(response);
            }

        } catch (error) {
            alert("Something went wrong while login");
        }
    }

    return (
        <div className="add-post-card" >
            <h1>Login</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    ref={emailRef}
                    placeholder="Email"
                    className="text-input"
                />
                <input
                    type="password"
                    ref={passwordRef}
                    placeholder="Password"
                    className="text-input"
                />
                <div className="button-group">
                    <button type="submit" className="add-button">Login</button>
                </div>
            </form>

        </div>
    );
}

export default Login;