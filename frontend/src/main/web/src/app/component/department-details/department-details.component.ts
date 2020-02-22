import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap} from '@angular/router';

@Component({
  selector: 'app-department-details',
  template: `
    <h3>
      You selected department where id = {{ departmentId }}
        Department Name = {{ departmentName }}
      <nav>
          <a (click)="onPrevious()">Previous</a>
          <a (click)="onNext()">Next</a>
      </nav>
    </h3>
  `,
  styles: []
})
export class DepartmentDetailsComponent implements OnInit {

  public departmentId;
  public departmentName;

  constructor(private activateRouter: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    //let id = parseInt(this.activateRouter.snapshot.paramMap.get("id"));
    //this.departmentId=id;

    this.activateRouter.paramMap.subscribe((params: ParamMap) => {
      let id = parseInt(params.get('id'));
      this.departmentId = id;

      let deptName = params.get('name');
      this.departmentName = name;
    });
  }

  onPrevious(){
    let previousId = this.departmentId - 1;
    this.router.navigate(['/departments',previousId]);
  }

  onNext(){
    let nextId = this.departmentId + 1;
    this.router.navigate(['/departments',nextId]);
  }
}
