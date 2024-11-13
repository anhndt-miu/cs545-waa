import React, { useState } from 'react';

function AddPost({ onAddPost }) {
    const [formData, setFormData] = useState({
        title: '', content: '', author :'Alice Johnson', user_id:1
    });



    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleClear = (e) => {
        setFormData({
            title: '', content: ''
        });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        if (formData.title.trim().length === 0 || formData.content.trim().length === 0) {
            alert("Please fill in all fields");
        } else {
            onAddPost(formData);
            handleClear();
        }

    };

    const isSubmitDisabled = !formData.title.trim() || !formData.content.trim();

    return (
        <div className="add-post-card" >
            <h1>Add Post</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="title"
                    value={formData.title}
                    onChange={handleChange}
                    placeholder="Enter title"
                    className="text-input"
                />
                <input
                    type="text"
                    name="content"
                    value={formData.content}
                    onChange={handleChange}
                    placeholder="Enter content"
                    className="text-input"
                />
                <div className="button-group">
                    <button type="submit" className="add-button" disabled={isSubmitDisabled}>Add Post</button>
                    <button type="button" onClick={handleClear} className="clear-button" disabled={isSubmitDisabled}>Clear</button>
                </div>
            </form>

        </div>
    );
}

export default AddPost;