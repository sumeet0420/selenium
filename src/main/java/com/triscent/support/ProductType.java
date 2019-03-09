package com.triscent.support;

public enum ProductType implements Categories {

    BOOKS("BOOKS"){
        public String URL(){
            return "http://demowebshop.tricentis.com/books";
        }
    },
    APPARELS("APPAREL & SHOES"){
        public String URL(){
            return "http://demowebshop.tricentis.com/apparel-shoes";
        }
    },
    DIGITAL_DOWNLOADS("DIGITAL DOWNLOADS"){
        public String URL(){
            return "http://demowebshop.tricentis.com/digital-downloads";
        }
    },
    JEWELRY("JEWELRY"){
        public String URL(){
            return "http://demowebshop.tricentis.com/jewelry";
        }
    },
    GIFT_CARDS("GIFT CARDS"){
        public String URL(){
            return "http://demowebshop.tricentis.com/gift-cards";
        }
    };

    public final String category;

    public String URL(){
        throw new AbstractMethodError();
    }

    ProductType(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public enum  COMPUTERS implements Categories{
        DESKTOPS ("Desktop"){
            public String URL(){
                return "http://demowebshop.tricentis.com/desktops";
            }
        },
        NOTEBOOKS("Notebooks"){
            public String URL(){
                return "http://demowebshop.tricentis.com/notebooks";
            }
        },
        ACCESSORIES("Accessories"){
            public String URL(){
                return "http://demowebshop.tricentis.com/accessories";
            }
        };
        public String URL(){
            throw new AbstractMethodError();
        }
        public final String subCategory;
        COMPUTERS(String subCategory) {
            this.subCategory = subCategory;
        }

        @Override
        public String getCategory() {
            return subCategory;
        }
    }

    public enum ELECTONICS implements Categories{
        CAMERA("Camera, photo"){
            public String URL(){
                return "http://demowebshop.tricentis.com/camera-photo";
            }
        },
        CELLPHONES("Cell phones"){
            public String URL(){
                return "http://demowebshop.tricentis.com/cell-phones";
            }
        };

        public final String subCategory;
        ELECTONICS(String subCategory) {
            this.subCategory = subCategory;
        }

        public String URL(){
            throw new AbstractMethodError();
        }
        @Override
        public String getCategory() {
            return subCategory;
        }
    }

}