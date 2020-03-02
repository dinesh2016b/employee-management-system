import { Component } from '@angular/core';
import { environment } from './../environments/environment';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})

export class AppComponent {
    title = 'Employee Management System';

    constructor() {
        console.log('-------> environment : '+environment.production); // Logs false for default environment
    }
}
