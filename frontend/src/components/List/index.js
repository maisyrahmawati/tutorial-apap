import React from "react";

import Item from "components/Item";

export default function List({ title, items, onItemClick }) {
    return (
        <>
            <h3 style={StyleSheet.heading}>{title}</h3>
            <div className="list-group">
                {items.map((item) => (
                    <item key={item.id} item={item} onChange={onItemClick} />
                ))}
            </div>
        </>
    );
}

const styles = {
    heading: {
        fontFamily: "courier new",
    },
};