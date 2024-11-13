import './App.css';
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from 'react-router-dom';
import Dashboard from "./components/Dashboard";
import PostDetail from './components/PostDetail';

function App() {
    return (
        <div className="App">
            <Router
                future={{
                    v7_relativeSplatPath: true,
                    v7_startTransition: true,
                }}
            >
                <Routes>
                    <Route path="/" element={<Dashboard />} />
                    <Route path="/posts/:id" element={<PostDetail />} />
                </Routes>
            </Router>
        </div>

    );
}

export default App;
