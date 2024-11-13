import React, { useState } from 'react';

function AddComment({ onAddComment }) {
    const [formData, setFormData] = useState({
        name: '',
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
            name: "",
        });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        if (formData.name.trim().length === 0) {
            alert("Please fill in all fields");
        } else {
            // Post.updateById(post.id, formData);
            // onRefresh();
            onAddComment(formData);
            handleClear();
        }

    };

    const isSubmitDisabled = !formData.name.trim();

    return (
        <div className="add-comment" >
            <h1>Add comment</h1>
            <form onSubmit={handleSubmit}>
                        <input
                            type="text"
                            name="name"
                            value={formData.name}
                            onChange={handleChange}
                            placeholder="Enter comment"
                            className="text-input"
                        />
                <div className="button-group">
                    <button type="submit" className="add-button" disabled={isSubmitDisabled}>Add Comment</button>
                    <button type="button" onClick={handleClear} className="clear-button" disabled={isSubmitDisabled}>Clear</button>
                </div>
            </form>

        </div>
    );
}

export default AddComment;