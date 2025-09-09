# 3D Geometry Mesh Builder

## Overview
A lightweight 3D geometry engine implemented in **Java 17**. The project models core geometric primitives and composes them into a validated cube mesh. It was developed for Purdue CS coursework to practice **object-oriented design** and **computational geometry**.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [API Overview](#api-overview)
  - [Point](#point)
  - [UnitVector](#unitvector)
  - [Triangle](#triangle)
  - [Face](#face)
  - [Cube](#cube)
  - [GeoFactory (provided)](#geofactory-provided)
- [Precision & Formatting Rules](#precision--formatting-rules)
- [Skills Demonstrated](#skills-demonstrated)
- [Build & Run](#build--run)


## Features
- 3D primitives: `Point`, `UnitVector`, `Triangle`.
- Mesh composition: `Face` (two triangles) and `Cube` (six faces).
- Automatic **surface normal** computation via cross product.
- Strict validity checks for faces/cube (shared edges, consistent/opposite normals).
- Clean, human-readable `toString()` outputs to aid debugging.

## Project Structure
src/
- Cube.java
- Face.java
- GeoFactory.java # provided tester (do not modify)
- Main.java # optional driver
- Point.java
- RunLocalTest.java # optional local tests
- Triangle.java
- UnitVector.java


## API Overview

### Point
Represents a 3D coordinate `(x, y, z)`.  
**Key:** getters/setters, `equals(Point)` with tolerance, and a `toString()` formatted to **exactly 3 decimals**.

### UnitVector
Normalized direction in 3D. Constructible from `(i, j, k)` or from two `Point`s; **auto-normalizes**, and provides `crossProduct(UnitVector b)`.  
Invalid vectors (magnitude 0) are represented as `<InvalidUnitVector>`.

### Triangle
Defined by three vertices `A, B, C`. Its surface normal is computed as **AB × AC** (order matters).  
Provides `getVertices()`, `getSurfaceNormal()`, `equals`, and formatted `toString()`.

### Face
A square face composed of **two adjacent triangles** that:
- share **two vertices** and
- have **identical** surface normals.

If invalid, `toString()` returns `{InvalidFace}`.

### Cube
A mesh of **six faces**. Validation ensures:
- each face shares an edge with **four** others;
- **opposite** faces have **opposite** normals;
- no duplicated faces.

If invalid, `toString()` returns `|InvalidCube|`.

### GeoFactory (provided)
Interactive CLI utility for constructing and testing the classes. Intended for manual tests; do not modify.

## Precision & Formatting Rules
- Doubles are treated as equal if within **±0.0001**.
- All printed double values must use **exactly 3 decimals** in `toString()`.
  
## Skills Demonstrated
- Object-Oriented Programming (abstraction, encapsulation, invariants).
- Computational Geometry (cross product, normals, mesh validation).
- Readable API design and robust string formatting for diagnostics.

## Build & Run
### Command line
```bash
javac src/*.java
java -cp src Main          # or run GeoFactory if provided as the entry point


