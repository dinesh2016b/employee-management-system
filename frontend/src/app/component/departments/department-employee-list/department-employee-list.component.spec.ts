import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DepartmentEmployeeListComponent } from './department-employee-list.component';

describe('DepartmentEmployeeListComponent', () => {
  let component: DepartmentEmployeeListComponent;
  let fixture: ComponentFixture<DepartmentEmployeeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DepartmentEmployeeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DepartmentEmployeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
