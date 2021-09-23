import { TestBed } from '@angular/core/testing';

import { PostService } from './post.service';
import {url} from "../../main";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

describe('PostServiceService', () => {
  let service: PostService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        url,
        Injectable,
        HttpClient
      ],
    });
    service = TestBed.inject(PostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
