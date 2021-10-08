import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBotonComponent } from './list-boton.component';

describe('ListBotonComponent', () => {
  let component: ListBotonComponent;
  let fixture: ComponentFixture<ListBotonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBotonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBotonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
