import './App.css';
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from 'react-router-dom';
import Dashboard from "./components/Dashboard";
import PostDetail from './components/PostDetail';
import TopBar from './components/TopBar';
import AddPost from './components/AddPost';
import Login from './components/Login';
import PageRoutes from './routes/PageRoutes';
import { Fragment } from 'react';

function App() {
    return (
        <div className="App">

            <Router
                future={{
                    v7_relativeSplatPath: true,
                    v7_startTransition: true,
                }}
            >
                <Fragment>
                    <TopBar />
                    <PageRoutes />
                </Fragment>
                {/* <Routes>
                    <Route path="/login" element={<Login />} />
                </Routes>
                <Routes>
                    <Route path="/" element={<Dashboard />} />
                    <Route path="/post" element={<AddPost />} />
                    <Route path="/posts/:id" element={<PostDetail />} />
                </Routes> */}
            </Router>
        </div>

    );
}

export default App;
