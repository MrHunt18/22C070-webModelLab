
const BookingForm = {
    init: function() {
        this.form = document.getElementById('form');
        this.firstName = document.getElementById('firstName');
        this.lastName = document.querySelector('input[placeholder="Enter here"]');
        this.email = document.getElementById('email');
        this.phone = document.getElementById('phone');
        this.date = document.querySelector('input[type="date"]');
        
        this.nameError = document.getElementById('name_error');
        this.lastnameError = document.getElementById('lastname_error');
        this.emailError = document.getElementById('email_error');
        this.phoneError = document.getElementById('phone_error');
        this.dateError = document.getElementById('date_error');
        
        this.form.addEventListener('submit', this.handleSubmit.bind(this));
    },
    
    validate: function() {
        let isValid = true;
        
        
        if (!this.firstName.value.trim()) {
            this.nameError.textContent = 'First name is required';
            isValid = false;
        } else {
            this.nameError.textContent = '';
        }
        
     
        if (!this.lastName.value.trim()) {
            this.lastnameError.textContent = 'Last name is required';
            isValid = false;
        } else {
            this.lastnameError.textContent = '';
        }
        
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(this.email.value.trim())) {
            this.emailError.textContent = 'Invalid email format';
            isValid = false;
        } else {
            this.emailError.textContent = '';
        }
        
    
        const phonePattern = /^[0-9]{10}$/;
        if (!phonePattern.test(this.phone.value.trim())) {
            this.phoneError.textContent = 'Invalid phone number';
            isValid = false;
        } else {
            this.phoneError.textContent = '';
        }
        
       
        if (!this.date.value) {
            this.dateError.textContent = 'Date is required';
            isValid = false;
        } else {
            this.dateError.textContent = '';
        }
        
        return isValid;
    },
    
    handleSubmit: function(event) {
        event.preventDefault();
        
        if (this.validate()) {
           
            console.log('Form submitted successfully');
          
        } else {
            console.log('Form validation failed');
        }
    }
};


BookingForm.init();
